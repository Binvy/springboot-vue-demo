package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Movie;
import com.binvi.springboot.demo03.service.MovieService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author binvi
 * @version 1.0
 * @Description: MyBatis实现
 * @date 2019/6/11 18:00
 */
@RestController
@RequestMapping("/movie/mapper/")
public class MovieController2 {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieService2 movieService;

    @PostMapping("/add")
    public String addMovie() {
        logger.info("add movie start");
        Movie movie = Movie.getInstance();
        logger.info("movie:[{}]", movie);
        movieService.addMovie(movie);
        return movie.toString();
    }

    @PostMapping("/update")
    public String updateMovie(Movie movie) {
        logger.info("update movie start. movie:[{}]", movie);
        movieService.updateMovie(movie);
        return movie.toString();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable(value = "id")Integer id) {
        logger.info("delete movie start. id:[{}]", id);
        movieService.deleteMovieById(id);
    }

    @GetMapping("/get/{id}")
    public String getMovieById(@PathVariable(value = "id")Integer id) {
        logger.info("get movie by id start. id:[{}]", id);
        return movieService.getMovieById(id).toString();
    }

    @GetMapping("/all")
    public String getAllMovies() {
        logger.info("get all movies start.");
        return movieService.getAllMovies().toString();
    }

}
