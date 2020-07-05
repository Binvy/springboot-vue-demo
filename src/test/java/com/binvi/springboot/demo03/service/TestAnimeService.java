package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.entity.Anime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: Service测试
 * @date 2019/6/13 22:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAnimeService {

    @Autowired
    AnimeService animeService;

    @Test
    public void testFindAll() {
        List<Anime> animes = animeService.findAll();
        Assert.assertNotNull("anime is null", animes);
    }

}
