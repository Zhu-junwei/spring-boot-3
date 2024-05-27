package com.zjw.message.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author 朱俊伟
 * @since 2023/11/08 17:29
 */
@Component
public class MyKafkaListener {

    //默认的监听是从消息队列最后一个消息开始拿。新消息才能拿到
    @KafkaListener(topics = {"FIRSTTOPIC"}, groupId = "g1")
    public void firstTopic(ConsumerRecord record){
        System.out.println("[topic]:" + record.topic() +
                " [key]:" + record.key() +
                " [value]:" + record.value());
    }

    //拿到以前的完整消息;
    @KafkaListener(groupId = "g2",topicPartitions={
            @TopicPartition(topic="FIRSTTOPIC",partitionOffsets={
                    @PartitionOffset(partition="0",initialOffset = "0")
            })
    })
    public void firstTopicNew(ConsumerRecord record){
        System.out.println("[topic]:" + record.topic() +
                " [key]:" + record.key() +
                " [value]:" + record.value());
    }
}
