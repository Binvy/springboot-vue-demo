package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/9 14:17
 */
@Component
@Order(1)
public class MyApplicationRunner1 implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner1.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        logger.info("custom application runner with order[1]: " + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String name : optionNames) {
            logger.info("key:{}, value:{}.", name, args.getOptionValues(name));
        }
    }
}
