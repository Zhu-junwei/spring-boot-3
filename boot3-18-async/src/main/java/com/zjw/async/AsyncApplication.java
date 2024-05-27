package com.zjw.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 通过@EnableAsync注解，启用了Spring对异步方法的支持。
 */
@SpringBootApplication
@EnableAsync
public class AsyncApplication {

    public static void main(String[] args) {
        // 启动Spring Boot应用程序
        SpringApplication.run(AsyncApplication.class, args);
    }

}
