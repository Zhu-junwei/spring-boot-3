package com.zjw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发布确认生产者
 * @author 朱俊伟
 * @since 2022/09/08
 */
@AllArgsConstructor
@RestController
@RequestMapping("/confirm")
@Slf4j
public class SendConfirmMsgController {

    public static final String CONFIRM_EXCHANGE_NAME = "confirm.exchange";

    private final RabbitTemplate rabbitTemplate;


    @GetMapping("sendMessage/{message}")
    public void sendMessage(@PathVariable String message){
        //指定消息id为1
        String routingKey = "key1";
        CorrelationData correlationData = new CorrelationData("1");
        rabbitTemplate.convertAndSend(CONFIRM_EXCHANGE_NAME, routingKey, message+routingKey, correlationData);

        correlationData = new CorrelationData("2");
        routingKey = "key2";
        rabbitTemplate.convertAndSend(CONFIRM_EXCHANGE_NAME, routingKey, message+routingKey, correlationData);

        log.info("发送消息内容:{}", message);
    }
}
