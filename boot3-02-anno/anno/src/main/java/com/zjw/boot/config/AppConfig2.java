package com.zjw.boot.config;

import com.zjw.boot.bean.Sheep;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 启用对{@link Sheep @Sheep}类的配置属性支持，Spring Boot会尝试将应用的属性文件中的属性绑定到{@link Sheep @Sheep}类类上
 *
 * <p>{@code @EnableConfigurationProperties}注解用于启用对 {@code @ConfigurationProperties}注解的支持。
 * 这通常与配置属性类一起使用，用于绑定外部配置（如 {@code application.properties}或 {@code application.yml}文件中的属性）到一个类的字段上。
 * {@link Sheep @Sheep}类需要使用 {@code @ConfigurationProperties}注解，通常还会指定一个前缀，用于绑定配置文件中以该前缀开头的属性。
 *
 * @author 朱俊伟
 */
@Configuration
@EnableConfigurationProperties(Sheep.class)
public class AppConfig2 {

}
