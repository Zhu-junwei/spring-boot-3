package com.zjw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Date;

/**
 * 定时任务 需要开启EnableScheduling注解
 * @author zjw
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    /**
     * 根据定时任务的执行频率，定时任务
     * fixedRate = 1000*2 2S执行一次
     */
    @Scheduled(fixedRate = 1000*2 )
    public void sayHello1(){
        System.out.println("sayHello1 --- " + DateFormat.getDateTimeInstance().format(new Date()));
    }

    /**
     * 使用cron表达式定义定时任务
     */
    @Scheduled(cron = "*/2 * * * * *")
    public void sayHello2(){
        System.out.println("sayHello2 --- " + DateFormat.getDateTimeInstance().format(new Date()));
    }
}
