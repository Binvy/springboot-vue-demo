package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Direct下的消费者组件
 * @date 2019/6/23 21:03
 */
@Component
public class RabbitDirectReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitDirectReceiver.class);

    @RabbitListener(queues = "direct-queue")
    public void handler(String message) {
        logger.info("[RabbitMQ] direct receiver handler start. message:{}", message);
    }

}
