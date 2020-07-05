package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.component.MyCacheKeyGenerator;
import com.binvi.springboot.demo03.entity.Anime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author binvi
 * @version 1.0
 * @Description: 基础Dao类，包含CRUD等基本操作
 * @date 2019/6/15 10:04
 */
@Repository
@CacheConfig(cacheNames = "base_cache")
public class BasicDao {

    @Autowired
    MyCacheKeyGenerator myCacheKeyGenerator;

    private static final Logger logger = LoggerFactory.getLogger(BasicDao.class);

    @Cacheable
    public Anime get() {
        logger.info("===============get=================");
        return Anime.getInstance();
    }

    @CachePut(keyGenerator = "myCacheKeyGenerator")
    public Anime update(Anime anime) {
        logger.info("===============update=================");
        return anime;
    }

    @CacheEvict(key = "#id")
    public Anime delete(Integer id) {
        logger.info("===============delete=================");
        Anime anime = Anime.getInstance();
        anime.setId(id);
        return anime;
    }

    @Cacheable
    public Anime save(Anime anime) {
        logger.info("===============add=================");
        return anime;
    }

}
