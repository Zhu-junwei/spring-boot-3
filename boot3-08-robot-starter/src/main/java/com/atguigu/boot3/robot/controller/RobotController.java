package com.atguigu.boot3.robot.controller;

import com.atguigu.boot3.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @date 2023/10/30 22:20
 */
@RestController
public class RobotController {

    @Autowired
    RobotService robotService;

    @GetMapping("/robot/hello")
    public String sayHello(){
        String s = robotService.sayHello();
        return s;
    }
}
