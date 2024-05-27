package com.zjw.boot.config;

import com.zjw.boot.bean.Cat;
import com.zjw.boot.bean.Dog;
import com.zjw.boot.bean.Pig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 条件注解
 * @author 朱俊伟
 */
@Configuration
public class AppConfig3 {

    /**
     * 当类路径下存在Pig类时，创建Cat对象注册到Spring容器中，id默认是方法名
     */
    @ConditionalOnClass(name = "com.zjw.boot.bean.Pig")
//    @ConditionalOnClass(Pig.class)
    @Bean
    public Cat cat() {
        return new Cat();
    }

    /**
     * 当类路径下存在Pig类时，创建Dog对象注册到Spring容器中，id默认是方法名
     */
    @ConditionalOnMissingClass(value = "com.zjw.boot.bean.Pig")
    @Bean
    public Dog dog() {
        return new Dog();
    }

    /**
     * 当Spring容器中存在Pig对象时，创建Cat对象注册到Spring容器中，id默认是方法名
     */
    @ConditionalOnBean(Pig.class)
    @Bean
    public Cat cat1() {
        return new Cat();
    }

    /**
     * 当Spring容器中不存在Pig对象时，创建Dog对象注册到Spring容器中，id默认是方法名
     */
    @ConditionalOnMissingBean(Pig.class)
    @Bean
    public Dog dog1() {
        return new Dog();
    }

}
