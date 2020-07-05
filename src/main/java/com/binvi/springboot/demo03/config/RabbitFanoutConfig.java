package com.binvi.springboot.demo03.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Fanout配置
 * @date 2019/6/23 21:14
 */
@Configuration
public class RabbitFanoutConfig {

    public static final String FANOUT_NAME = "fanout-name";

    @Bean
    Queue fanoutQueueOne() {
        return new Queue("fanout-queue-one");
    }

    @Bean
    Queue fanoutQueueTwo () {
        return new Queue("fanout-queue-two");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_NAME, true, false);
    }

    @Bean
    Binding fanoutBindingOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    Binding fanoutBindingTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }

}
