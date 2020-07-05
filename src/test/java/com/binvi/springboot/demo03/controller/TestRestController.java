package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Anime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author binvi
 * @version 1.0
 * @Description: Rest测试
 * @date 2019/6/13 22:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestRestController {

    private static final Logger logger = LoggerFactory.getLogger(TestRestController.class);

    @Autowired
    TestRestTemplate template;

    @Test
    public void test() {
        ResponseEntity<String> responseEntity = template.getForEntity("/animes/22", String.class);
        logger.info(responseEntity.toString());

        Anime anime = Anime.getInstance();

        responseEntity = template.postForEntity("/animes", anime, String.class);
        logger.info(responseEntity.toString());

        anime.setPrice(new BigDecimal(22.55));
        template.put("/animes/23", anime);

        template.delete("/animes/24");
    }

}
