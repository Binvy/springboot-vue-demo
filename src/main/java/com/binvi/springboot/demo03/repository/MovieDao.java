package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: JDBC实现数据库连接层
 * @date 2019/6/9 18:05
 */
@Repository
public class MovieDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addMovie(Movie movie) {
        return jdbcTemplate.update(
                "insert into movie (name, author, publish_date, price, description, remark) values (?, ?, ?, ?, ?, ?)",
                movie.getName(), movie.getAuthor(), movie.getPublishDate(), movie.getPrice(), movie.getDescription(), movie.getRemark());
    }

    public int updateMovie(Movie movie) {
        return jdbcTemplate.update(
                "update movie set name = ?, author = ?, publish_date = ?, price = ?, description = ?, remark = ? where id = ?",
                movie.getName(), movie.getAuthor(), movie.getPublishDate(), movie.getPrice(), movie.getDescription(), movie.getRemark(), movie.getId());
    }

    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from movie where id = ?", id);
    }

    public Movie getMovieById(Integer id) {
        return jdbcTemplate.queryForObject("select * from movie where id = ?", new BeanPropertyRowMapper<>(Movie.class), id);
    }

    public List<Movie> getAllMovies() {
        return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<>(Movie.class));
    }

}
