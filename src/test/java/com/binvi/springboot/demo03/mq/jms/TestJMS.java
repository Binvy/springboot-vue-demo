package com.binvi.springboot.demo03.mq.jms;

import com.binvi.springboot.demo03.component.JmsComponent;
import com.binvi.springboot.demo03.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author binvi
 * @version 1.0
 * @Description: JMS测试类
 * @date 2019/6/23 18:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJMS {

    @Autowired
    JmsComponent jmsComponent;

    @Test
    public void contextLoad() {
        Message message = new Message();
        message.setName("test");
        message.setContent("hello jms");
        jmsComponent.send(message);
    }

}
