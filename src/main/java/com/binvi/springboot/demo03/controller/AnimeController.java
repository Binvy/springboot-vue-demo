package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Anime;
import com.binvi.springboot.demo03.service.AnimeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/11 19:41
 */
@RestController
@RequestMapping("anime")
public class AnimeController {

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    AnimeService animeService;

    @PostMapping("add")
    public String add() {
        logger.info("anime add start");
        Anime anime = Anime.getInstance();
        logger.info("anime:[{}]", anime);
        animeService.addAnime(anime);
        return anime.toString();
    }

    @GetMapping("page")
    public String getByPage() {
        logger.info("anime get by page start");
        PageRequest pageRequest = PageRequest.of(2, 3);
        Page<Anime> animes = animeService.getAnimeByPage(pageRequest);
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(animes);
            logger.info("result: {}", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @GetMapping("search")
    public String search() {
        logger.info("anime search start");
        Map<String, List<Anime>> result = Maps.newHashMap();
        result.put("getAnimesByAuthorStartingWith", animeService.getAnimesByAuthorStartingWith("one"));
        result.put("getBooksByPriceGreaterThanEqual", animeService.getBooksByPriceGreaterThanEqual(new BigDecimal(0)));
        result.put("getAnimeByIdAndAuthor", animeService.getAnimeByIdAndAuthor("one", 1));
        result.put("getAnimesByIdAndName", animeService.getAnimesByIdAndName("One Punch Man", 2));
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(result);
            logger.info("result: {}", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
