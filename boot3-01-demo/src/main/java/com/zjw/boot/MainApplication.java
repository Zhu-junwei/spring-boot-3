package com.zjw.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 朱俊伟
 * @since 2023/10/19 6:44
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(MainApplication.class, args);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
