package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.entity.Movie;
import com.binvi.springboot.demo03.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author binvi
 * @version 1.0
 * @Description: JDBC实现
 * @date 2019/6/9 18:32
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovie() {
        logger.info("add movie start");
        Movie movie = Movie.getInstance();
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
