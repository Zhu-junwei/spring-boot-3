package com.zjw.robot;

import com.zjw.robot.controller.RobotController;
import com.zjw.robot.properties.RobotProperties;
import com.zjw.robot.service.RobotService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 朱俊伟
 * @Description
 * @since 2023-04-27 20:15
 */
//给容器中导入Robot功能要用的所有组件
@Import({RobotController.class,RobotProperties.class, RobotService.class})
@Configuration
public class RobotAutoConfiguration {

}
