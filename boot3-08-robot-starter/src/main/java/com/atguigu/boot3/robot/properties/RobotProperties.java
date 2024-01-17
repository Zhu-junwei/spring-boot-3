package com.atguigu.boot3.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 朱俊伟
 * @since 2023/10/30 22:18
 */
@Data
@Component
@ConfigurationProperties(prefix = "robot")
public class RobotProperties {
    private String name;
    private String age;
    private String email;
}
