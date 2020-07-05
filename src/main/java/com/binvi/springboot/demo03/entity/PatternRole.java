package com.binvi.springboot.demo03.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 22:05
 */
@Data
@Entity(name = "pattern_role")
public class PatternRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String patternId;
    private String roleId;

}
