package com.zjw.redis.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 朱俊伟
 * @since 2024/03/04 22:31
 */
@SpringBootTest
@Slf4j
class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 测试String
     */
    @Test
    public void testString(){
        String key = "name";
        String expectedValue = "redis";

        // 设置键值对
        redisUtil.set(key, expectedValue);

        // 从Redis获取值
        String actualValue = redisUtil.getString(key);

        // 断言获取的值和期望值相等
        assertEquals(expectedValue, actualValue, "The value retrieved from Redis does not match the expected value.");

        // 可以选择输出日志，确认测试的执行和结果
        log.info("Expected value: {}, Actual value: {}", expectedValue, actualValue);
    }

    /**
     * 测试list
     */
    @Test
    public void testList() {
        redisUtil.delete("list");

        String key = "list";
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        redisUtil.pushAll(key, list);

        List<String> all = redisUtil.listAll(key);
        assertEquals(list.size(), all.size(),"数量不一致");

        log.info("Expected list size: {}, Actual list size: {}", list, all);
    }

    /*
        Set
        ZSet
        Hash
     */
}