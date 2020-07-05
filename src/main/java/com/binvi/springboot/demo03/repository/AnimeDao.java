package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.entity.Anime;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: JPA实现数据库连接层
 * @date 2019/6/11 19:21
 */
@CrossOrigin
//path:请求路径中的animes, collectionResourceRel:返回的JSON集合中的animes，itemResourceRel:返回的JSON集合中的单个anime
//@RepositoryRestResource(path = "animes", collectionResourceRel = "animes", itemResourceRel = "anime")
@CacheConfig(cacheNames = "anime_cache")
public interface AnimeDao extends JpaRepository<Anime, Integer> {

    @RestResource(path = "author", rel = "author")
    @Cacheable
    List<Anime> getAllByAuthorStartingWith(String author);

    @RestResource(exported = false)
    @Cacheable
    List<Anime> getAllByPriceGreaterThanEqual(BigDecimal price);

    @Query(value = "select * from anime where id = (select max(id) from anime)", nativeQuery = true)
    @Cacheable
    Anime getAnimeMaxId();

    @Query(value = "select a from anime a where a.id > :id and a.author = :author")
    @Cacheable
    List<Anime> getAnimesByIdAndAuthor(@Param("author")String author, @Param("id") Integer id);

    @Query("select a from anime a where a.id < ?2 and a.name like %?1%")
    @Cacheable
    List<Anime> getAnimesByIdAndName(String name, Integer id);

}
