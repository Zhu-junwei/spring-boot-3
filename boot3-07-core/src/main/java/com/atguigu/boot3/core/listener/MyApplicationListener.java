package com.atguigu.boot3.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * SpringBoot的生命周期
 * @author 朱俊伟
 * @since 2023/10/30 16:46
 */
@Slf4j
public class MyApplicationListener implements SpringApplicationRunListener {

    /**
     * 在run方法首次启动时立即调用。可以用于非常早期的初始化。
     */
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("***starting***");
    }

    /**
     * 环境准备好就会调用，但是在 ApplicationContext 创建前
     */
    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("***environmentPrepared***");
    }

    /**
     * ApplicationContext已经被创建，但是还未加载
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("***contextPrepared***");
    }

    /**
     * 在ApplicationContext加载后但在刷新之前调用
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("***contextLoaded***");
    }

    /**
     * ApplicationContext已经刷新，但是CommandLineRunners和ApplicationRunners还未被调用
     */
    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("***started***");
    }

    /**
     * 在调用了CommandLineRunners和ApplicationRunners后，ApplicationContext容器run方法运行之前运行
     */
    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("***ready***");
    }

    /**
     * 在应用程序运行出错时运行
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("***failed***");
    }
}
