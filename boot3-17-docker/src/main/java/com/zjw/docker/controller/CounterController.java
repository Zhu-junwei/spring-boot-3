package com.zjw.docker.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/11/01 19:48
 */
@RestController
@AllArgsConstructor
public class CounterController {

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/")
    public String count() {
        Long countPeople = redisTemplate.opsForValue().increment("count-people");
        return "有【"+ countPeople +"】人访问该页面";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
