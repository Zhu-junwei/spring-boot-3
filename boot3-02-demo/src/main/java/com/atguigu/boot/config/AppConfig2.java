package com.atguigu.boot.config;

import com.atguigu.boot.bean.Cat;
import com.atguigu.boot.bean.Dog;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 朱俊伟
 */

@Configuration
//@SpringBootApplication
public class AppConfig2 {

    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01() {
        return new Cat();
    }

    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog  dog01() {
        return new Dog();
    }

    @ConditionalOnBean(Cat.class)
    @Bean
    public User zhangSan(){
        User user = new User();
        user.setName("张三");
        user.setId(1L);
        return user;
    }

    @ConditionalOnMissingBean(Cat.class)
    @Bean
    public User lisi(){
        User user = new User();
        return user;
    }

}
