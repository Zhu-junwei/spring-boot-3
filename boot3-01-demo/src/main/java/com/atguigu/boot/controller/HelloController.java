package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @date 2023/10/19 6:47
 */
@RestController
public class HelloController {

    @GetMapping("/hello") //请求路径
    public String hello(){
        return "Hello World!";
    }
}
