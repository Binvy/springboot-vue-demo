package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.entity.Movie;
import com.binvi.springboot.demo03.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: MyBatis实现Service
 * @date 2019/6/11 17:43
 */
@Service
public class MovieService2 {

    @Autowired
    MovieMapper movieMapper;

    public int addMovie(Movie movie) {
        return movieMapper.addMovie(movie);
    }

    public int updateMovie(Movie movie) {
        return movieMapper.updateMovieById(movie);
    }

    public int deleteMovieById(Integer id) {
        return movieMapper.deleteMovieById(id);
    }

    public Movie getMovieById(Integer id) {
        return movieMapper.getMovieById(id);
    }

    public List<Movie> getAllMovies() {
        return movieMapper.getAllMovies();
    }

}
