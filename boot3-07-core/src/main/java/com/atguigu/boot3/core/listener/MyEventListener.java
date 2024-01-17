package com.atguigu.boot3.core.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author 朱俊伟
 * @since 2023/10/30 18:02
 */
public class MyEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("--[event]--" + event.getClass().getName());
    }
}
