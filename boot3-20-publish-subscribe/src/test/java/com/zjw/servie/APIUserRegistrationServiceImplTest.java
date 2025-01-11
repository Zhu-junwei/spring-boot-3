package com.zjw.servie;

import com.zjw.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户通过API注册测试类
 * @author zjw
 * @since 2025/01/11 19:13
 */
@SpringBootTest
class APIUserRegistrationServiceImplTest {
    @Autowired
    private APIUserRegistrationService apiUserRegistrationService;

    @Test
    void registerUser() {
        User user = new User();
        user.setName("zjw");
        user.setAge(25);
        apiUserRegistrationService.registerUser(user);
    }
}