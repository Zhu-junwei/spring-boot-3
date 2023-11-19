package com.atguigu.boot3.core.service;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 日志服务
 * @author 朱俊伟
 * @date 2023/10/30 19:09
 */
@Service
@Slf4j
public class SysService {

    @EventListener
    @Order(3)
    public void onEvent(LoginSuccessEvent event){
        log.info("SysService.onEvent....");
        UserEntity user = (UserEntity) event.getSource();
        recordLog(user);
    }

    public void recordLog(UserEntity user){
        System.out.println(user.getUsername() + "登录信息已被记录");
    }
}
