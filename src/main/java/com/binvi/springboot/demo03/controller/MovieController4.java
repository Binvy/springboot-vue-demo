package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Movie;
import com.binvi.springboot.demo03.mapper1.MovieMapper1;
import com.binvi.springboot.demo03.mapper2.MovieMapper2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: MyBatis多数据源控制器
 * @date 2019/6/11 22:13
 */
//@RestController
//@RequestMapping("dbs/mybatis")
public class MovieController4 {

    private static final Logger logger = LoggerFactory.getLogger(MovieController4.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MovieMapper1 movieMapper1;
    @Autowired
    MovieMapper2 movieMapper2;

    @GetMapping("/test")
    public String test() {
        logger.info("MyBatis多数据源测试：dbs mybatis test start");
        List<Movie> movies1 = movieMapper1.getAllMovies();
        logger.info("movies1: {}", movies1);
        List<Movie> movies2 = movieMapper2.getAllMovies();
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
