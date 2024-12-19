package com.zjw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.zjw.config.TtlQueueConfig.*;


/**
 * 发送ttl消息
 * @author 朱俊伟
 * @since 2022/09/06 23:36
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/ttl")
public class SendTTLMsgController {

    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者发送消息
     * @param message   消息
     */
    @GetMapping("sendMsg/{message}")
    public void sendMsg(@PathVariable String message) {
        log.info("当前时间:{},发送一条信息给两个TTL队列:{}", new Date(), message);
        rabbitTemplate.convertAndSend(EXCHANGE_X, ROUTING_KEY_XA, "消息来自ttl为10S的队列" + message);
        rabbitTemplate.convertAndSend(EXCHANGE_X, ROUTING_KEY_XB, "消息来自ttl为40S的队列" + message);
    }

    /**
     * 生产者发送消息和过期时间
     * @param message   消息
     * @param ttlTime   过期时间，单位是毫秒
     */
    @GetMapping("sendExpirationMsg/{message}/{ttlTime}")
    public void sendMsg(@PathVariable String message,
                        @PathVariable String ttlTime) {
        log.info("当前时间:{},发送一条时长{}毫秒信息给队列QC:{}", new Date(), ttlTime, message);
        rabbitTemplate.convertAndSend(EXCHANGE_X, ROUTING_KEY_XC, message, messagePostProcessor -> {
            messagePostProcessor.getMessageProperties().setExpiration(ttlTime);
            return messagePostProcessor;
        });
    }

    /**
     * 生产者发送消息
     * @param message   消息
     */
    @GetMapping("sendDropMsg/{message}")
    public void sendDropMsg(@PathVariable String message) {
        log.info("当前时间:{},发送一条信息给过期丢弃的TTL队列:{}", new Date(), message);
        rabbitTemplate.convertAndSend(EXCHANGE_X, ROUTING_KEY_XE, "消息来自ttl为10S的队列" + message);
    }
}
