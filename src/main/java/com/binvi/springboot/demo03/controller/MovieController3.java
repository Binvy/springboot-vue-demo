package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: JDBC多数据源控制器
 * @date 2019/6/11 20:28
 */
//@RestController
//@RequestMapping("dbs/jdbc")
public class MovieController3 {

    private static final Logger logger = LoggerFactory.getLogger(MovieController3.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Resource(name = "jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @RequestMapping("test")
    public String test() {
        logger.info("JDBC多数据源测试：dbs jdbc test start");
        List<Movie> movies1 = jdbcTemplateOne.query("select * from movie", new BeanPropertyRowMapper<>(Movie.class));
        logger.info("movies1: {}", movies1);
        List<Movie> movies2 = jdbcTemplateTwo.query("select * from movie", new BeanPropertyRowMapper<>(Movie.class));
        logger.info("movies2: {}", movies2);
        Map<String, List<Movie>> map = Maps.newHashMap();
        map.put("movies1", movies1);
        map.put("movies2", movies2);
        String result = null;
        try {
            result = OBJECT_MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            logger.error("json 转换异常!", e);
        }
        return result;
    }

}
