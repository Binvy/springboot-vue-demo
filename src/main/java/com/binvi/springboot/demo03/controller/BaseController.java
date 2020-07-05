package com.binvi.springboot.demo03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description: 基础控制器类
 * @date 2019/6/15 16:08
 */
@RestController
public class BaseController {

    @GetMapping("test")
    public String get() {
        return "test";
    }

}
