package com.binvi.springboot.demo03.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 22:03
 */
@Data
@Entity(name = "pattern")
public class Pattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String pattern;
    @Transient
    private List<Role> roles;

}
