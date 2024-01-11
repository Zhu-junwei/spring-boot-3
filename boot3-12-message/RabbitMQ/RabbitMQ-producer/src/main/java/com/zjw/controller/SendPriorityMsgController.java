package com.zjw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.zjw.config.PriorityConfig.PRIORITY_EXCHANGE_NAME;
import static com.zjw.config.PriorityConfig.PRIORITY_ROUTING_KEY;


/**
 * 发送优先级消息
 * <p>
 * 消息的优先级是相对于队列的优先级而言的。如果队列的最大优先级是10，那么消息的优先级可以在1到10的范围内设置。
 *
 * @author 朱俊伟
 * @since 2022/09/06 23:36
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/priority")
public class SendPriorityMsgController {

    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者发送消息
     *
     * @param message 消息
     */
    @GetMapping("sendMsg/{message}")
    public void sendMsg(@PathVariable String message) {
        log.info("当前时间:{},发送优先级消息给priority.queue队列:{}", new Date(), message);
        // 连续发送送10条消息，偶数设置优先级高一点
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                MessagePostProcessor messagePostProcessor = msg -> {
                    MessageProperties properties = msg.getMessageProperties();
                    properties.setPriority(5);
                    return msg;
                };
                rabbitTemplate.convertAndSend(PRIORITY_EXCHANGE_NAME, PRIORITY_ROUTING_KEY, message + i, messagePostProcessor);
            } else {
                rabbitTemplate.convertAndSend(PRIORITY_EXCHANGE_NAME, PRIORITY_ROUTING_KEY, message + i + message);
            }

        }
    }
}
