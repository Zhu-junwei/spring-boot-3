package com.zjw.boot.config;

import com.zjw.boot.bean.Pig;
import com.zjw.boot.bean.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 声明这是一个配置类，Spring Boot在启动时会自动读取这个类中的配置信息
 * @author 朱俊伟
 */
@Configuration
public class AppConfig {

    /**
     * 创建Pig对象注册到Spring容器中，id默认是方法名，默认是单例的
     */
    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
        return new Pig();
    }

    /**
     * 创建多例User对象注册到Spring容器中，id为user22
     */
    @Bean("user22")
    @Scope("prototype")
    public User user(){
        User user = new User();
        user.setName("张三");
        user.setId(1L);
        return user;
    }

}
