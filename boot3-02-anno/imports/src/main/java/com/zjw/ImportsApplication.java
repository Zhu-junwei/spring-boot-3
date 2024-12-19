package com.zjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 朱俊伟
 * @since 2024/03/15 14:21
 */
@SpringBootApplication
public class ImportsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportsApplication.class, args);
        System.out.println(context.containsBean("com.zjw.domain.Dog"));
        System.out.println(context.containsBean("com.zjw.domain.Cat"));
    }
}
