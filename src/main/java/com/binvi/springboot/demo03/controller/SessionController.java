package com.binvi.springboot.demo03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/12 18:45
 */
@RestController
@RequestMapping("session")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Value("${server.port}")
    String port;

    @PostMapping("save")
    public String saveName(String name, HttpSession session) {
        logger.info("session controller save name start. name:[{}], session:[{}]", name, session);
        session.setAttribute("name", name);
        return port;
    }

    @GetMapping("get")
    public String getName(HttpSession session) {
        logger.info("session controller get name start. session:[{}]", session);
        return port + ":" + session.getAttribute("name").toString();
    }

}
