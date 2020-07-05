package com.binvi.springboot.demo03.component;

import com.binvi.springboot.demo03.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Topic下的消费者组件
 * @date 2019/6/23 21:35
 */
@Component
public class RabbitTopicReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitTopicReceiver.class);

    @RabbitListener(queues = "topic-queue-phone")
    public void handlerOne(String message) {
        logger.info("[RabbitMQ] topic receiver handler phone start. message: {}", message);
    }

    @RabbitListener(queues = "topic-queue-xiaomi")
    public void handlerTwo(String message) {
        logger.info("[RabbitMQ] topic receiver handler xiaomi start. message: {}", message);
    }

    @RabbitListener(queues = "topic-queue-huawei")
    public void handlerThree(String message) {
        logger.info("[RabbitMQ] topic receiver handler huawei start. message: {}", message);
    }

}
