package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义监听器listener，这里使用ServletRequestListener。
 *      对于其他的listener，比如HttpSessionListener、ServletContextListener也是支持的。
 * @date 2019/6/9 14:31
 */
@WebListener
public class MyListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("custom listener request initialized");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("custom listener request destroyed");
    }
}
