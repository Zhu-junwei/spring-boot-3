package com.atguigu.actuator.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

/**
 * @author 朱俊伟
 * @since 2023/11/10 12:57
 */
@Service
public class HelloService {

    Counter counter = null;

    public HelloService(MeterRegistry  registry) {
        counter = registry.counter("hello.counter");
    }

    public String hello() {
        counter.increment();
        return "hello";
    }
}
