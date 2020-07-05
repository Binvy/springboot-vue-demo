package com.binvi.springboot.demo03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/5/29 22:49
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("hello")
    public String hello(Model model) {
        Map<String, Object> map = model.asMap();
        logger.info("map:[{}]", map);
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = map.get(key);
            logger.info("key:[{}], value:[{}]", key, value);
        }
        return "hello";
    }

}
