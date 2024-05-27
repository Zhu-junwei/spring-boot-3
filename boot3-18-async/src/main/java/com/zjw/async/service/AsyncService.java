package com.zjw.async.service;

import java.util.concurrent.CompletableFuture;

/**
 * 异步服务接口，提供异步执行方法的定义。
 *
 * @author 朱俊伟
 * @since 2024/05/11 16:07
 */
public interface AsyncService {
    /**
     * 异步执行的方法，返回一个CompletableFuture，代表异步操作的结果。
     *
     * @return CompletableFuture<String> 异步操作完成后的结果，是一个字符串。
     */
    CompletableFuture<String>  asyncMethod();
}
