package com.zjw.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消费优先级队列消费者
 *
 * @author 朱俊伟
 * @since 2022/09/06 23:42
 */
@Slf4j
@Component
public class PriorityQueueConsumer {

    @RabbitListener(queues = {"priority.queue"})
    public void receiveD(Message message, Channel channel) {
        String msg = new String(message.getBody());
        log.info("当前时间:{},收到优先级队列的消息:{}", new Date(), msg);
    }
}
