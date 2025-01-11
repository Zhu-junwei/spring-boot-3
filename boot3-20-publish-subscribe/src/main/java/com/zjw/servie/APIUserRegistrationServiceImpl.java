package com.zjw.servie;

import com.zjw.domain.User;
import com.zjw.envent.UserRegisteredEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 通过用户注册API注册用户
 * @author zjw
 * @since 2025/01/11 19:06
 */
@Service
@AllArgsConstructor
public class APIUserRegistrationServiceImpl implements APIUserRegistrationService {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void registerUser(User user) {
        // 业务逻辑处理
        // ...
        // 发布用户注册事件
        UserRegisteredEvent event = new UserRegisteredEvent(this, user);
        eventPublisher.publishEvent(event);
    }
}
