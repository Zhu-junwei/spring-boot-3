package com.zjw.robot.service;

import com.zjw.robot.properties.RobotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱俊伟
 * @since 2023/10/30 22:20
 */
@Service
public class RobotService {

    @Autowired
    RobotProperties robotProperties;

    public String sayHello(){
        return "你好：名字：【"+robotProperties.getName()+"】;年龄：【"+robotProperties.getAge()+"】";
    }
}
