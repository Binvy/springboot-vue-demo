package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.component.Couple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/5/30 1:01
 */
@RestController
public class CoupleController {

    @Autowired
    Couple couple;

    @GetMapping("/couple")
    public String couple() {
        return couple.toString();
    }
}
