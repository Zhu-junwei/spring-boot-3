package com.zjw.core.event;

import com.zjw.core.entity.UserEntity;
import org.springframework.context.ApplicationEvent;

/**
 * 登录成功事件
 *
 * @author 朱俊伟
 * @since 2023/10/30 18:56
 */
public class LoginSuccessEvent extends ApplicationEvent {

    /**
     * @param source 代表是谁登录成了
     */
    public LoginSuccessEvent(UserEntity source) {
        super(source);
    }
}
