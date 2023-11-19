package com.atguigu.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.redis.mapper")
public class Boot309RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot309RedisApplication.class, args);
    }

}
