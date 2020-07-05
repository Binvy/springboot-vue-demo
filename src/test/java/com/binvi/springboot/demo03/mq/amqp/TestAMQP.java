package com.binvi.springboot.demo03.mq.amqp;

import com.binvi.springboot.demo03.config.RabbitDirectConfig;
import com.binvi.springboot.demo03.config.RabbitFanoutConfig;
import com.binvi.springboot.demo03.config.RabbitHeaderConfig;
import com.binvi.springboot.demo03.config.RabbitTopicConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/23 21:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAMQP {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testDirect() {
        rabbitTemplate.convertAndSend("direct-queue", "this is rabbitmq direct-queue message!");
    }

    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUT_NAME, null, "this is rabbitmq fanout-queue-one message");
    }

    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "xiaomi.news", "小米新闻...");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "huawei.news", "华为新闻...");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "xiaomi.phone", "小米手机...");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "huawei.phone", "华为手机...");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "phone.news", "手机新闻...");
    }

    @Test
    public void testHeader() {
        Message messageName = MessageBuilder
                .withBody("Hello header! header-queue-name".getBytes())
                .setHeader("name", "binvi")
                .build();
        Message messageAge = MessageBuilder
                .withBody("Hello header! header-queue-age".getBytes())
                .setHeader("age", 27)
                .build();
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADER_NAME, null, messageName);
        rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADER_NAME, null, messageAge);
    }

}
