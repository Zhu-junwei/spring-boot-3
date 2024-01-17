package com.atguigu.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/11/10 10:15
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!Spring Security";
    }

    @PreAuthorize("hasAuthority('world_exec')")
    @GetMapping("/world")
    public String world(){
        return "Hello World!!!";
    }
}
