package com.zjw.listener;

import com.zjw.envent.UserRegisteredEvent;
import com.zjw.servie.APIUserRegistrationService;
import com.zjw.servie.UserRegistrationService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zjw
 * @since 2025/01/11 18:55
 */

/**
 * 通过实现 ApplicationListener 接口，并指定监听的事件类型，可以监听到 Spring 容器中发布的事件。
 */
@Component
public class UserRegisteredListener implements ApplicationListener<UserRegisteredEvent> {

    @Override
    public void onApplicationEvent(UserRegisteredEvent event) {
        // 监听到用户注册事件，打印用户信息
        Object eventSource = event.getSource();
        // 区分事件的来源做不同的处理
        if (eventSource instanceof UserRegistrationService) {
            System.out.println("User website registered: " + event.getUser());
        } else if (eventSource instanceof APIUserRegistrationService) {
            System.out.println("User API registered: " + event.getUser());
        }
    }
}
