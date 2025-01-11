package com.zjw.servie;

import com.zjw.envent.UserRegisteredEvent;

/**
 * @author zjw
 * @since 2025/01/11 19:02
 */
public interface EmailService {
    void handleUserRegisteredEvent(UserRegisteredEvent event);
}
