package com.binvi.springboot.demo03.mapper;

import com.binvi.springboot.demo03.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/11 16:26
 */
//@Mapper
@Repository
public interface MovieMapper {

    int addMovie(Movie movie);

    int updateMovieById(Movie movie);

    int deleteMovieById(Integer id);

    Movie getMovieById(Integer id);

    List<Movie> getAllMovies();

}
