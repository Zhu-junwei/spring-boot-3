package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld Demo Controller
 *
 * @author 朱俊伟
 * @since 2023/10/19 6:47
 */
@RestController
public class HelloController {

    /**
     * <a href="http://localhost:9999/hello">http://localhost:9999/hello</a>
     * @return 字符串"Hello World!"
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
