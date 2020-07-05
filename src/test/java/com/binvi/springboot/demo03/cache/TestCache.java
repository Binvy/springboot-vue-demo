package com.binvi.springboot.demo03.cache;

import com.binvi.springboot.demo03.entity.Anime;
import com.binvi.springboot.demo03.repository.AnimeDao;
import com.binvi.springboot.demo03.repository.BasicDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 9:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCache {

    private static final Logger logger = LoggerFactory.getLogger(TestCache.class);

    @Autowired
    AnimeDao animeDao;
    @Autowired
    BasicDao basicDao;

    @Test
    public void testAnime() {
        logger.info("cache test-anime start");

        animeDao.getAllByAuthorStartingWith("one");
        animeDao.getAllByAuthorStartingWith("one");
        animeDao.getAllByAuthorStartingWith("one");
        logger.info("===============================");

        animeDao.getAnimesByIdAndAuthor("one", 22);
        animeDao.getAnimesByIdAndAuthor("one", 22);
        animeDao.getAnimesByIdAndAuthor("one", 22);
        logger.info("===============================");

        animeDao.getAllByPriceGreaterThanEqual(new BigDecimal(0));
        animeDao.getAllByPriceGreaterThanEqual(new BigDecimal(0));
        animeDao.getAllByPriceGreaterThanEqual(new BigDecimal(0));
        logger.info("===============================");

        animeDao.getAnimeMaxId();
        animeDao.getAnimeMaxId();
        animeDao.getAnimeMaxId();
        logger.info("===============================");

        animeDao.getAnimesByIdAndName("火影忍者", 20);
        animeDao.getAnimesByIdAndName("火影忍者", 20);
        animeDao.getAnimesByIdAndName("火影忍者", 20);
        logger.info("===============================");

    }

    @Test
    public void testBasic() {
        logger.info("cache test-basic start");
        Anime anime = Anime.getInstance();
        anime.setId(1);

        basicDao.save(anime);
        basicDao.save(anime);
        basicDao.save(anime);

        basicDao.delete(1);
        basicDao.delete(1);
        basicDao.delete(1);

        basicDao.update(anime);
        basicDao.update(anime);
        basicDao.update(anime);

        basicDao.get();
        basicDao.get();
        basicDao.get();

    }

}
