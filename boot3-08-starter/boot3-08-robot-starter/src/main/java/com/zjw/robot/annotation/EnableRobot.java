package com.zjw.robot.annotation;

import com.zjw.robot.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
/**
 * 该注解用于启用机器人功能。
 * 当在配置类上使用此注解时，它会触发Spring容器加载{@link RobotAutoConfiguration}类，
 * 从而进行相应的机器人功能配置。
 *
 * @author 朱俊伟
 * @since 2023-04-27 20:24
 * @see EnableRobot 注解的详细说明
 */
@Retention(RetentionPolicy.RUNTIME) // 注解的保留策略为运行时
@Target({ElementType.TYPE}) // 注解适用于类型（类、接口等）
@Documented // 将此注解包含在Javadoc中
@Import(RobotAutoConfiguration.class) // 导入RobotAutoConfiguration配置类
public @interface EnableRobot {
}
