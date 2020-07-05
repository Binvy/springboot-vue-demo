package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/12 16:11
 */
@RestController
@RequestMapping("redis")
public class SongController {

    public static final Logger logger = LoggerFactory.getLogger(SongController.class);

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("test")
    public String test() throws ParseException {
        logger.info("song controller test start");
        ValueOperations<String, String> svo = stringRedisTemplate.opsForValue();
        svo.set("name", "来自天堂的魔鬼");
        String name = svo.get("name");
        logger.info("name:[{}]", name);

        ValueOperations vo = redisTemplate.opsForValue();
        vo.set("song", Song.getInstance());
        Song song = (Song) vo.get("song");
        logger.info("song:[{}]", song);

        return song.toString();
    }

}
