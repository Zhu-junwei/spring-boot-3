package com.zjw.servie;

import com.zjw.domain.User;
import com.zjw.envent.UserRegisteredEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author zjw
 * @since 2025/01/11 18:49
 */
@Service
@AllArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void registerUser(User user) {
        // 执行用户注册逻辑，如保存用户信息到数据库等

        // 注册成功后发布事件
        UserRegisteredEvent event = new UserRegisteredEvent(this, user);
        eventPublisher.publishEvent(event);
    }
}
