package com.binvi.springboot.demo03.config;

import com.google.common.collect.Maps;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Header配置
 * @date 2019/6/23 22:00
 */
@Configuration
public class RabbitHeaderConfig {

    public static final String HEADER_NAME = "header-name";

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADER_NAME, true, false);
    }

    @Bean
    Queue headerQueueName() {
        return new Queue("header-queue-name");
    }

    @Bean
    Queue headerQueueAge() {
        return new Queue("header-queue-age");
    }

    @Bean
    Binding headerBindingName() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", "binvi");
        return BindingBuilder.bind(headerQueueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding headerBindingAge() {
        return BindingBuilder.bind(headerQueueAge()).to(headersExchange()).where("age").exists();
    }

}
