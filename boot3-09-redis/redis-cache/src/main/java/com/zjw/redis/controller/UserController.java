package com.zjw.redis.controller;

import com.zjw.redis.entity.TUser;
import com.zjw.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:15
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{uid}")
    public TUser  getUserById(@PathVariable("uid") Long id) {
        log.info("查询id={}用户",id);
        return userService.getById(id);
    }
}
