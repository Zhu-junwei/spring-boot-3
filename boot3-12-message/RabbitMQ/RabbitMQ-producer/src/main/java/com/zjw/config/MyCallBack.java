package com.zjw.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 交换机的回调接口
 * @author 朱俊伟
 * @since 2022/09/08
 */
@AllArgsConstructor
@Component
@Slf4j
public class MyCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 交换机不管是否收到消息的一个回调方法。
     * @param correlationData  回调的关联数据。
     * @param ack ACK 为 true，nack 为 false
     * @param cause 可选原因，用于 nack，如果可用，否则为 null。
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("交换机收到id为{}的消息",id);
        } else {
            log.info("交换机未确认收到id为{}的消息，由于原因{}", id, cause);
        }
    }



    /**
     * Returned message callback.
     * 如果通过延迟队列发送的消息，由于消息是在延迟交换机中，还没有到达延迟队列，也会被交换机调用退回方法，不过等待消息到达延迟时间后会再发送到队列中
     * 如果交换机是发布确认，但是设置了备份交换机，消息会被发送到备份交换机中，不会被退回。如果没有备份交换机，消息会被退回。
     * @param returned the returned message and metadata.
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.warn("消息:{},被交换机退回:{},退回原因:{},路由Key:{}",
                new String(returned.getMessage().getBody()),
                returned.getExchange(),
                returned.getReplyText(),
                returned.getRoutingKey());
    }
}
