package com.zjw.core.service;

import com.zjw.core.entity.UserEntity;
import com.zjw.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 优惠券服务
 * @author 朱俊伟
 * @since 2023/10/30 19:06
 */
@Service
@Slf4j
public class CouponService {

    @Order(1)
    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        log.info("CouponService.onEvent....");
        UserEntity user = (UserEntity) loginSuccessEvent.getSource();
        sendCoupon(user);
    }

    public void sendCoupon(String username){
        System.out.println(username + " 随机得到了一张优惠券");
    }

    public void sendCoupon(UserEntity user){
        sendCoupon(user.getUsername());
    }
}
