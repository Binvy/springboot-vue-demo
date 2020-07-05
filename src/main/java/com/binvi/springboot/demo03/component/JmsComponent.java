package com.binvi.springboot.demo03.component;

import com.binvi.springboot.demo03.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/23 18:45
 */
@Component
public class JmsComponent {

    private static final Logger logger = LoggerFactory.getLogger(JmsComponent.class);

    @Autowired
    JmsMessagingTemplate messagingTemplate;
    @Autowired
    Queue queue;

    public void send(Message message) {
        logger.info("send start. message:[{}]", message);
        messagingTemplate.convertAndSend(this.queue, message);
    }

    @JmsListener(destination = "amq")
    public void receive(Message message) {
        logger.info("receive start. message[{}]", message);
    }

}
