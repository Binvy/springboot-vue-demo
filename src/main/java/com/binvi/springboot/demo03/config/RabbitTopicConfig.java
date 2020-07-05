package com.binvi.springboot.demo03.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Topic配置
 * @date 2019/6/23 21:28
 */
@Configuration
public class RabbitTopicConfig {

    public static final String TOPIC_NAME = "topic-name";

    @Bean
    Queue xiaomi() {
        return new Queue("topic-queue-xiaomi");
    }

    @Bean
    Queue huawei() {
        return new Queue("topic-queue-huawei");
    }

    @Bean
    Queue phone() {
        return new Queue("topic-queue-phone");
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_NAME, true, false);
    }

    @Bean
    Binding topicBindingOne() {
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }

    @Bean
    Binding topicBindingTwo() {
        return BindingBuilder.bind(huawei()).to(topicExchange()).with("huawei.#");
    }

    @Bean
    Binding topicBindingThree() {
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }

}
