package com.zjw.features.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/10/30 14:28
 */
@RestController
public class SystemController {

    @Value("${version:1.0.1}")
    String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
