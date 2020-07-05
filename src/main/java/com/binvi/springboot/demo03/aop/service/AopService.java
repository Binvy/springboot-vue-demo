package com.binvi.springboot.demo03.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/9 15:26
 */
@Service
public class AopService {

    private static final Logger logger = LoggerFactory.getLogger(AopService.class);

    public String start() {
        logger.info("aop service start");
        return "start";
    }

    public String end() {
        logger.info("aop service end");
        return "end";
    }

}
