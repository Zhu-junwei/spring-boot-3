package com.zjw.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 设置队列的优先级
 * @author 朱俊伟
 * @since 2022/09/08
 */
@Configuration
public class PriorityConfig {

    public static final String PRIORITY_EXCHANGE_NAME = "priority.exchange";
    public static final String PRIORITY_QUEUE_NAME = "priority.queue";
    public static final String PRIORITY_ROUTING_KEY = "key1";

    /**
     * 创建优先级交换机
     * @return 交换机
     */
    @Bean("priorityExchange")
    public DirectExchange priorityExchange(){
        return new DirectExchange(PRIORITY_EXCHANGE_NAME);
    }

    /**
     * 创建优先级队列
     * @return 队列
     */
    @Bean("priorityQueue")
    public Queue priorityQueue(){
        Map<String, Object> args = Map.of("x-max-priority", 10);
        return QueueBuilder.durable(PRIORITY_QUEUE_NAME).withArguments(args).build();
//        return new Queue(PRIORITY_QUEUE_NAME,true,false,false,args);
    }

    /**
     * 队列和交换机绑定
     */
    @Bean
    public Binding bindingPriorityQueue(@Qualifier("priorityQueue") Queue queue,
                                        @Qualifier("priorityExchange") DirectExchange priorityExchange) {
        return BindingBuilder.bind(queue).to(priorityExchange).with(PRIORITY_ROUTING_KEY);

    }
}
