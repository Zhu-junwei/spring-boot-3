package com.zjw.redis.service;

import com.zjw.redis.entity.TUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 朱俊伟
 * @since 2024/03/08 12:04
 */
@SpringBootTest
@Slf4j
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void getUserById() {
        TUser user1 = userService.getById(1L);
        System.out.println("user1 = " + user1);
        TUser user2 = userService.getById(2L);
        System.out.println("user2 = " + user2);
        System.out.println(user1.equals(user2));
    }

    @Test
    void save() {
        TUser user = TUser.builder()
                .loginName("王五")
                .passwd("123").build();
        userService.saveUser(user);
    }

    @Test
    void getUserByName(){
        TUser user = userService.getUserByName("王五");
        System.out.println("user = " + user);
    }

    @Test
    void delete() {
        TUser user = userService.getUserByName("王五");
        System.out.println("user = " + user);
        userService.removeById(user.getId());
    }
}