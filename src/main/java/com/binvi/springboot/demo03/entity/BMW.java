package com.binvi.springboot.demo03.entity;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/17 23:42
 */
@Data
public class BMW {

    @Size(min = 2, max = 3)
    private String bmw;

}
