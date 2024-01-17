package com.atguigu.boot3.features.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 朱俊伟
 * @since 2023/10/30 14:51
 */
@SpringBootTest
class HelloControllerTest {

    @Autowired
    HelloController  helloController;
    @Test
    void hello() {
        helloController.hello();
    }
}