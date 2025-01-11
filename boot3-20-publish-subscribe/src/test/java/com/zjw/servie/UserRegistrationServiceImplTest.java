package com.zjw.servie;

import com.zjw.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author zjw
 * @since 2025/01/11 18:57
 */
@SpringBootTest
class UserRegistrationServiceImplTest {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Test
    void register() {
        User user = new User();
        user.setName("zjw");
        user.setAge(25);
        userRegistrationService.registerUser(user);
        // should publish a message to the message broker
    }
}