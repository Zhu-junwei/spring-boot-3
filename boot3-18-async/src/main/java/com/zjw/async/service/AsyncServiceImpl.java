package com.zjw.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * 提供异步服务的实现类。
 * @author 朱俊伟
 * @since 2024/05/11 16:07
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    /**
     * 异步执行一个方法。
     * @return CompletableFuture<String> 表示异步操作完成的结果。
     */
    @Async
    @Override
    public CompletableFuture<String> asyncMethod() {
        try {
            // 模拟一个耗时操作，以展示异步执行的效果
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // 中断当前线程，保持中断状态
            Thread.currentThread().interrupt();
        }
        // 返回一个已完成的Future，包含异步操作的结果消息
        return CompletableFuture.completedFuture("Async operation completed!");
    }
}
