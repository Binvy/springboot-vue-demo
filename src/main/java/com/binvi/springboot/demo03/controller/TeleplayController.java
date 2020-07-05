package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Teleplay;
import com.binvi.springboot.demo03.repository.TeleplayDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/12 18:14
 */
@RestController
@RequestMapping("mongo")
public class TeleplayController {

    private static final Logger logger = LoggerFactory.getLogger(TeleplayController.class);

    @Autowired
    TeleplayDao teleplayDao;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("test")
    public String test() {
        logger.info("teleplay controller test start");

        List<Teleplay> teleplays = Lists.newArrayList();

        Teleplay teleplay1 = Teleplay.getInstance();
        teleplay1.setId(3);
        teleplays.add(teleplay1);

        Teleplay teleplay2 = Teleplay.getInstance();
        teleplay2.setName("GOT");
        teleplay2.setId(4);
        teleplays.add(teleplay2);

        teleplayDao.insert(teleplays);
        List<Teleplay> teleplayList = teleplayDao.findAll();
        List<Teleplay> teleplayList2 = teleplayDao.findByAuthorContains("George Raymond Richard Martin");
        List<Teleplay> teleplayList3 = teleplayDao.findByNameEquals("GOT");

        logger.info("teleplayList: [{}]", teleplayList);
        logger.info("teleplayList2: [{}]", teleplayList2);
        logger.info("teleplayList3: [{}]", teleplayList3);

        return teleplayList.toString();
    }

    @GetMapping("test2")
    public String test2() {
        logger.info("teleplay controller test2 start");

        Teleplay teleplay = Teleplay.getInstance();
        teleplay.setId(5);

        mongoTemplate.insert(teleplay);

        List<Teleplay> teleplayList = mongoTemplate.findAll(Teleplay.class);
        logger.info("teleplayList:[{}]", teleplayList);

        return teleplayList.toString();
    }

    @GetMapping("get")
    public String get() {
        logger.info("teleplay controller get start");
        List<Teleplay> teleplayList = mongoTemplate.findAll(Teleplay.class);
        logger.info("teleplayList:[{}]", teleplayList);
        return teleplayList.toString();
    }

}
