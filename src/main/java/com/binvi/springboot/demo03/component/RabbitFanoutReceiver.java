package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Fanout下的消费者组件
 * @date 2019/6/23 21:20
 */
@Component
public class RabbitFanoutReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitFanoutReceiver.class);

    @RabbitListener(queues = "fanout-queue-one")
    public void handlerOne(String message) {
        logger.info("[RabbitMQ] fanout receiver handler one start! message: {}", message);
    }

    @RabbitListener(queues = "fanout-queue-two")
    public void handlerTwo(String message) {
        logger.info("[RabbitMQ] fanout receiver handler two start. message: {}", message);
    }

}
