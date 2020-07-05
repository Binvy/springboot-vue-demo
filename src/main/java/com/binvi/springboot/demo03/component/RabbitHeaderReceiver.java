package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author binvi
 * @version 1.0
 * @Description: RabbitMQ策略之Header下的消费者组件
 * @date 2019/6/23 22:07
 */
@Component
public class RabbitHeaderReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitHeaderReceiver.class);

    @RabbitListener(queues = "header-queue-name")
    public void headerHandlerOne(byte[] message) {
        logger.info("[RabbitMQ] header receiver handler one start. message:{}", new String(message));
    }

    @RabbitListener(queues = "header-queue-age")
    public void headerHandlerTwo(byte[] message) {
        logger.info("[RabbitMQ] header receiver handler two start. message: {}", new String(message));
    }

}
