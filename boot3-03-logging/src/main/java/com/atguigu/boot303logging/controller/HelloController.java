package com.atguigu.boot303logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/10/22 11:15
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/h")
    public String hello(){
        log.trace("trace日志打印了");
        log.debug("debug日志打印");
        log.info("info日志打印了");
        log.warn("warn日志打印了");
        log.error("error日志打印了");
        return "hello";
    }
}
