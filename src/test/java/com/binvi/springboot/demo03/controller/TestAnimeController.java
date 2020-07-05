package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Anime;
import com.binvi.springboot.demo03.service.AnimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author binvi
 * @version 1.0
 * @Description: Controller测试
 * @date 2019/6/13 22:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAnimeController {

    private static final Logger logger = LoggerFactory.getLogger(TestAnimeController.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    AnimeService animeService;
    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/anime/page")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info("mvcResult: {}", mvcResult);
        logger.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void test2() throws Exception {
        Anime anime = Anime.getInstance();
        String json = OBJECT_MAPPER.writeValueAsString(anime);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/anime/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info("mvcResult: {}", mvcResult);
        logger.info(mvcResult.getResponse().getContentAsString());
    }

}
