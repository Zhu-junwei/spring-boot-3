package com.zjw.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 确认队列消费者，消费确认队列消息
 * @author 朱俊伟
 * @since 2022/09/08
 */
@Component
@Slf4j
public class ConfirmConsumer {

    public static final String CONFIRM_QUEUE_NAME = "confirm.queue";

    @RabbitListener(queues = CONFIRM_QUEUE_NAME)
    public void receiveMsg(Message message){
        String msg = new String(message.getBody());
        log.info("接受到队列confirm.queue消息:{}", msg);
    }
}
