package com.binvi.springboot.demo03.service;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/17 22:14
 */
public class CarService {

    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

}
