package com.zjw.async.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AsyncServiceTest {

    @Autowired
    private DemoService asyncService;

    @Test
    public void testAsyncMethod() throws Exception {
        CompletableFuture<String> future = asyncService.asyncMethod();
        // 等待异步操作完成并验证结果
        assertEquals("Async operation completed!", future.get());
    }
}