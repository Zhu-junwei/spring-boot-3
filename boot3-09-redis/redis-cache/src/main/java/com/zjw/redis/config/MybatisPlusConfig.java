package com.zjw.redis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 朱俊伟
 * @since 2024/03/08 17:09
 */
@Configuration
@MapperScan("com.zjw.redis.entity")
public class MybatisPlusConfig {

}
