package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.entity.Anime;
import com.binvi.springboot.demo03.repository.AnimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/11 19:34
 */
@Service
public class AnimeService {

    @Autowired
    AnimeDao animeDao;

    public List<Anime> findAll() {
        return animeDao.findAll();
    }

    public void addAnime(Anime anime) {
        if (anime == null) {
            anime = Anime.getInstance();
        }
        animeDao.save(anime);
    }

    public Page<Anime> getAnimeByPage(Pageable pageable) {
        return animeDao.findAll(pageable);
    }

    public List<Anime> getAnimesByAuthorStartingWith(String author) {
        return animeDao.getAllByAuthorStartingWith(author);
    }

    public List<Anime> getBooksByPriceGreaterThanEqual(BigDecimal price) {
        return animeDao.getAllByPriceGreaterThanEqual(price);
    }

    public Anime getAnimeMaxId() {
        return animeDao.getAnimeMaxId();
    }

    public List<Anime> getAnimeByIdAndAuthor(String author, Integer id) {
        return animeDao.getAnimesByIdAndAuthor(author, id);
    }

    public List<Anime> getAnimesByIdAndName(String name, Integer id) {
        return animeDao.getAnimesByIdAndName(name, id);
    }

}
