package com.binvi.springboot.demo03.entity;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/17 23:43
 */
@Data
public class Audi {

    @Size(min = 1, max = 4)
    private String audi;

}
