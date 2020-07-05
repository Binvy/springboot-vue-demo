package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/9 14:14
 */
@Component
@Order(2)
public class MyCommandLineRunner2 implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunner2.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("custom command line runner with order[2]: " + Arrays.toString(args));
    }
}
