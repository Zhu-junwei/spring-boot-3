package com.atguigu.boot3.ssm.controller;

import com.atguigu.boot3.ssm.bean.TUser;
import com.atguigu.boot3.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @date 2023/10/30 12:20
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public TUser getUser(@PathVariable("id") Long id){
        TUser user = userMapper.getUserById(id);
        return user;
    }
}
