package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.entity.Movie;
import com.binvi.springboot.demo03.repository.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: JDBC实现Service
 * @date 2019/6/9 18:27
 */
@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public int addMovie(Movie movie) {
        return movieDao.addMovie(movie);
    }

    public int updateMovie(Movie movie) {
        return movieDao.updateMovie(movie);
    }

    public int deleteMovieById(Integer id) {
        return movieDao.deleteById(id);
    }

    public Movie getMovieById(Integer id) {
        return movieDao.getMovieById(id);
    }

    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

}
