package com.binvi.springboot.demo03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/5/29 22:47
 */
@RestController
public class ErrorDefaultController {

    @GetMapping("error")
    public String error() {
        return "error";
    }

}
