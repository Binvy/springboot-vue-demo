package com.binvi.springboot.demo03.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/9 17:54
 */
@Data
public class Movie implements Serializable {

    private Integer id;
    private String name;
    private String author;
    private Date publishDate;
    private BigDecimal price;
    private String description;
    private String remark;

    public static Movie getInstance() {

        Movie movie = new Movie();
        movie.setName("Iron Man I");
        movie.setAuthor("Marvel");
        movie.setPrice(new BigDecimal(50.00));
        movie.setPublishDate(new Date());
        movie.setDescription("I am iron man");
        movie.setRemark("first movie in marvel world");
        return movie;
    }

}
