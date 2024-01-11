package com.zjw.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * TTL队列 配置文件类代码
 * @author 朱俊伟
 * @since 2022/09/06 22:01
 */
@Configuration
public class TtlQueueConfig {

    /**
     * 普通交换机名称
     */
    public static final String EXCHANGE_X = "X";
    /**
     * 死信交换机名称
     */
    public static final String EXCHANGE_DEAD_LETTER_Y = "Y";
    /**
     *普通队列名称
     */
    public static final String QUEUE_A = "QA";
    public static final String QUEUE_B = "QB";
    public static final String QUEUE_C = "QC";
    /**
     * 死信队列名称
     */
    public static final String DEAD_LETTER_QUEUE = "QD";
    /**
     * routing_key
     */
    public static final String ROUTING_KEY_XA = "XA";
    public static final String ROUTING_KEY_XB = "XB";
    public static final String ROUTING_KEY_XC = "XC";
    public static final String ROUTING_KEY_YD = "YD";

    /**
     * 直接交换机
     * @return 交换机
     */
    @Bean("xExchange")
    public DirectExchange xExchange(){
        return new DirectExchange(EXCHANGE_X);
    }

     /**
     * 死信交换机
     * @return 交换机
     */
    @Bean("yExchange")
    public DirectExchange yExchange(){
        return new DirectExchange(EXCHANGE_DEAD_LETTER_Y);
    }

    /**
     * 队列A
     * @return 队列
     */
    @Bean("queueA")
    public Queue queueA(){
        Map<String, Object> arguments = new HashMap<>();
        //设置死信交换机
        arguments.put("x-dead-letter-exchange", EXCHANGE_DEAD_LETTER_Y);
        //设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", ROUTING_KEY_YD);
        //设置TTL 单位是ms
        arguments.put("x-message-ttl", 10000);
        return QueueBuilder.durable(QUEUE_A).withArguments(arguments).build();
    }

    /**
     * 队列B
     * @return 队列
     */
    @Bean("queueB")
    public Queue queueB(){
        Map<String, Object> arguments = new HashMap<>();
        //设置死信交换机
        arguments.put("x-dead-letter-exchange", EXCHANGE_DEAD_LETTER_Y);
        //设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", ROUTING_KEY_YD);
        //设置TTL 单位是ms
        arguments.put("x-message-ttl", 40000);
        return QueueBuilder.durable(QUEUE_B).withArguments(arguments).build();
    }

    /**
     * 队列C
     * @return 队列
     */
    @Bean("queueC")
    public Queue queueC(){
        Map<String, Object> arguments = new HashMap<>();
        //设置死信交换机
        arguments.put("x-dead-letter-exchange", EXCHANGE_DEAD_LETTER_Y);
        //设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", ROUTING_KEY_YD);
        //没有设置TTL
        return QueueBuilder.durable(QUEUE_C).withArguments(arguments).build();
    }

    /**
     * 死信队列
     * @return 队列
     */
    @Bean("queueD")
    public Queue queueD(){
        return QueueBuilder.durable(DEAD_LETTER_QUEUE).build();
    }

    /**
     * 队列和交换机绑定
     * @param queueA 队列
     * @param xExchange 交换机
     * @return 绑定关系
     */
    @Bean
    public Binding queueABindingX(@Qualifier("queueA") Queue queueA,
                                  @Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueA).to(xExchange).with(ROUTING_KEY_XA);
    }

    /**
     * 队列和交换机绑定
     * @param queueB 队列
     * @param xExchange 交换机
     * @return 绑定关系
     */
    @Bean
    public Binding queueBBindingX(@Qualifier("queueB") Queue queueB,
                                  @Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueB).to(xExchange).with(ROUTING_KEY_XB);
    }

    /**
     * 队列和交换机绑定
     * @param queueC 队列
     * @param xExchange 交换机
     * @return 绑定关系
     */
    @Bean
    public Binding queueCBindingX(@Qualifier("queueC") Queue queueC,
                                  @Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueC).to(xExchange).with(ROUTING_KEY_XC);
    }

    /**
     * 队列和交换机绑定
     * @param queueD 队列
     * @param yExchange 交换机
     * @return 绑定关系
     */
    @Bean
    public Binding queueDBindingY(@Qualifier("queueD") Queue queueD,
                                  @Qualifier("yExchange") DirectExchange yExchange){
        return BindingBuilder.bind(queueD).to(yExchange).with(ROUTING_KEY_YD);
    }
}
