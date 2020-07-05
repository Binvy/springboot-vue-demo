package com.binvi.springboot.demo03.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Header配置
 * @date 2019/6/23 20:57
 */
@Configuration
public class RabbitDirectConfig {

    public static final String DIRECT_NAME = "direct-name";

    @Bean
    Queue directQueue() {
        return new Queue("direct-queue");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_NAME, true, false);
    }

    @Bean
    Binding directBinding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct-routing-key");
    }

}
