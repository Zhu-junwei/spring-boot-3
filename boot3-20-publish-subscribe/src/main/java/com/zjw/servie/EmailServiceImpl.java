package com.zjw.servie;

import com.zjw.envent.UserRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zjw
 * @since 2025/01/11 19:03
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 监听UserRegisteredEvent事件, 并发送邮件通知
     * @param event 用户注册事件
     */
    @EventListener
    @Async
    @Override
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        System.out.println("EmailService 发送邮件通知给用户：" + event.getUser().getName());
    }
}
