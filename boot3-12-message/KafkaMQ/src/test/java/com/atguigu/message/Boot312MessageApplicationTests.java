package com.atguigu.message;

import com.atguigu.message.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class Boot312MessageApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    void contextLoads() {

        //统计时间
        StopWatch stopWatch = new StopWatch();

        CompletableFuture[] futures = new CompletableFuture[1000];

        stopWatch.start();
        for (int i = 0; i < 1000; i++) {
            //JUC
            //发送消息，返回异步回调对象
            futures[i] = kafkaTemplate.send("FIRSTTOPIC", "key_" + i, "data_" + i);
        }
        CompletableFuture.allOf(futures).join();
        stopWatch.stop();

        System.out.println("发送完成，耗时(ms):" + stopWatch.getTotalTimeMillis());
    }

    /**
     * 测试kafka保存对象
     */
    @Test
    void testSaveObject() {
        Person person = Person.builder()
                .id(1L)
                .name("张三")
                .email("110@qq.com")
                .build();
        //默认使用的是org.apache.kafka.common.serialization.StringSerializer，保存对象需要配置JSON序列化器
        CompletableFuture completableFuture = kafkaTemplate.send("Person_TOPIC", person.getId().toString(), person);
        completableFuture.join();
        System.out.println("保存好了");
    }

}
