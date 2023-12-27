package com.atguigu.boot.config;

import com.atguigu.boot.bean.Sheep;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 启用对Sheep类的配置属性支持，Spring Boot会尝试将应用的属性文件中的属性绑定到Sheep类上
 */
@Configuration
@EnableConfigurationProperties(Sheep.class)
public class AppConfig2 {

}
