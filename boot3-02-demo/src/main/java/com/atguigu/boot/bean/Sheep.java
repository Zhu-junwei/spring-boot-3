package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sheep")
@Data
public class Sheep {

    private Long id;
    private String name;
    private Integer age;
}
