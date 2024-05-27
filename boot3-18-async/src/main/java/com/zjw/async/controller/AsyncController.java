package com.zjw.async.controller;

import com.zjw.async.service.AsyncService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * 异步处理控制器
 * @author 朱俊伟
 * @since 2024/05/11 16:09
 */
@RestController
public class AsyncController {

    @Resource
    AsyncService asyncService;

    /**
     * 异步测试方法
     * 该方法不接受参数，返回一个CompletableFuture，代表异步操作的结果。
     * @return CompletableFuture<String> 异步操作完成后的字符串结果
     */
    @RequestMapping("async")
    public CompletableFuture<String> testAsync(){
        System.out.println("async...");
        // 调用异步服务方法
        return asyncService.asyncMethod();
    }
}
