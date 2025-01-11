package com.zjw.async.controller;

import com.zjw.async.service.DemoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * 异步、同步处理控制器
 * @author 朱俊伟
 * @since 2024/05/11 16:09
 */
@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    // 调用同步方法
    @GetMapping("/sync")
    public String callSyncMethod() throws InterruptedException {
        long start = System.currentTimeMillis();
        String result = demoService.syncMethod();
        long end = System.currentTimeMillis();
        return String.format("同步方法返回: %s, 耗时: %dms", result, (end - start));
    }

    // 调用异步方法
    @GetMapping("/async")
    public String callAsyncMethod() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 调用两个异步的方法，如果不需要获取返回值，异步方法会在后台运行
        // 如果需要获取结果，可以调用 future.get()，进行阻塞等待状态
        CompletableFuture<String> future = demoService.asyncMethod();
        CompletableFuture<String> future2 = demoService.asyncMethod2();
        // 返回一个提示，实际任务在后台运行
        long end = System.currentTimeMillis();
        return String.format("异步方法已提交，耗时: %dms，请稍后查看日志", (end - start));
    }

    // 获取异步方法的结果
    @GetMapping("/async-result")
    public String getAsyncResult() throws Exception {
        CompletableFuture<String> future = demoService.asyncMethod();
        return String.format("异步方法返回: %s", future.get()); // 阻塞等待结果
    }
}