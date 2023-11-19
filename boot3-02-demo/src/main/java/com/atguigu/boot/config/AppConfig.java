package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import com.atguigu.boot.bean.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author 朱俊伟
 * @date 2023/10/19 22:59
 */

//@Import(FastsqlException.class)
@Configuration
//@SpringBootApplication
@EnableConfigurationProperties(Sheep.class)
public class AppConfig {

    @Bean("user22")
    @Scope("prototype")
    public User user(){
        User user = new User();
        user.setName("张三");
        user.setId(1L);
        return user;
    }

    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
        return new Pig();
    }

}
