package com.atguigu.boot3.robot;

import com.atguigu.boot3.robot.controller.RobotController;
import com.atguigu.boot3.robot.properties.RobotProperties;
import com.atguigu.boot3.robot.service.RobotService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lfy
 * @Description
 * @create 2023-04-27 20:15
 */
//给容器中导入Robot功能要用的所有组件
@Import({RobotController.class,RobotProperties.class, RobotService.class})
@Configuration
public class RobotAutoConfiguration {

}
