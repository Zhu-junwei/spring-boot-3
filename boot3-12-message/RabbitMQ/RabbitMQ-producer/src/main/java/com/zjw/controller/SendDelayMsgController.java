package com.zjw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.zjw.config.DelayedQueueConfig.DELAYED_EXCHANGE_NAME;
import static com.zjw.config.DelayedQueueConfig.DELAYED_ROUTING_KEY;

/**
 * 实现发送延迟消息，创建延迟的交换机，消息在达到指定延迟时间后才会发送到指定的队列中
 * @author 朱俊伟
 * @since 2022/09/06 23:36
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/delay")
public class SendDelayMsgController {

    private RabbitTemplate rabbitTemplate;

    /**
     * 发送延迟消息
     * @param message 消息内容
     * @param delayTime 延迟时间
     */
    @GetMapping("/{message}/{delayTime}")
    public void sendMsg(@PathVariable String message, @PathVariable Integer delayTime) {
        log.info("当前时间:{},发送一条时长{}毫秒信息给队列delayed.queue:{}", new Date(), delayTime, message);
        rabbitTemplate.convertAndSend(DELAYED_EXCHANGE_NAME, DELAYED_ROUTING_KEY, message, correlationData -> {
            //delayTime 单位：ms
            correlationData.getMessageProperties().setDelay(delayTime);
            return correlationData;
        });
    }
}
