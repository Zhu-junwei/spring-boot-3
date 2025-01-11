package com.zjw.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DemoService {

    // 同步方法
    public String syncMethod() throws InterruptedException {
        log.info("同步方法开始");
        Thread.sleep(3000); // 模拟耗时任务
        log.info("同步方法结束");
        return "同步结果";
    }

    // 异步方法
    @Async
    public CompletableFuture<String> asyncMethod() throws InterruptedException {
        log.info("异步方法开始");
        Thread.sleep(3000); // 模拟耗时任务
        log.info("异步方法结束");
        return CompletableFuture.completedFuture("异步结果");
    }

    // 异步方法
    @Async
    public CompletableFuture<String> asyncMethod2() throws InterruptedException {
        log.info("异步方法开始2");
        Thread.sleep(5000); // 模拟耗时任务
        log.info("异步方法结束2");
        return CompletableFuture.completedFuture("异步结果2");
    }
}
