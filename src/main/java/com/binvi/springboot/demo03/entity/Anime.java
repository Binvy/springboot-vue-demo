package com.binvi.springboot.demo03.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/11 19:08
 */
@Entity(name = "anime")
@Data
public class Anime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String author;

    private BigDecimal price;

    private String star;

    private Date publishDate;

    private String description;

    private String remark;

    @Transient
    private Boolean famous;

    public static Anime getInstance() {
        Anime anime = new Anime();
        anime.setName("One Punch Man");
        anime.setAuthor("one");
        anime.setPrice(new BigDecimal(0));
        anime.setStar("琦玉");
        anime.setPublishDate(new Date());
        anime.setDescription("平热系最强英雄传说");
        anime.setRemark("any one,just one punch");
        anime.setFamous(Boolean.TRUE);
        return anime;
    }

}
