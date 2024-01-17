package com.atguigu.boot3.core.controller;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.EventPublisher;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/10/30 18:57
 */
@RestController
public class LoginController {

    @Autowired
    EventPublisher eventPublisher;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("passwd")String passwd){
        //业务处理登录
        System.out.println("业务处理登录完成....");

        //1、创建事件信息
        LoginSuccessEvent event = new LoginSuccessEvent(new UserEntity(username, passwd));
        //2、发送事件
        eventPublisher.publishEvent(event);

        //设计模式：对新增开放，对修改关闭
        return username+"登录成功";
    }
}
