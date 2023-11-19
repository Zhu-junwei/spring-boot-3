package com.atguigu.message.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author 朱俊伟
 * @date 2023/11/08 17:23
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic kafkaProperties() {
        return TopicBuilder.name("new_topic")
                .partitions(1)
                .compact()
                .build();
    }
}
