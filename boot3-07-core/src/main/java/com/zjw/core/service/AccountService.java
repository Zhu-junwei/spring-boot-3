package com.zjw.core.service;

import com.zjw.core.entity.UserEntity;
import com.zjw.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 积分服务
 * @author 朱俊伟
 * @since 2023/10/30 19:03
 */
@Service
@Slf4j
@Order(2)
public class AccountService implements ApplicationListener<LoginSuccessEvent> {

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
      log.info("AccountService.onApplicationEvent.....");
        UserEntity user = (UserEntity) event.getSource();
        addAccountScore(user);
    }

    public void addAccountScore(UserEntity user){
        System.out.println(user.getUsername() +" 加了1分");
    }

}
