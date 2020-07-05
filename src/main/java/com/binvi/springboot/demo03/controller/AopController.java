package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.aop.service.AopService;
import com.binvi.springboot.demo03.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/9 15:21
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    BookService bookService;

    @Autowired
    AopService aopService;

    @GetMapping("/book/get/en")
    public String getEnBooks() {
        return bookService.generateEnBooks().toString();
    }

    @GetMapping("/book/get/cn")
    public String getCnBooks() {
        return bookService.generateCnBooks().toString();
    }

    @GetMapping("/start")
    public String start() {
        return aopService.start();
    }

    @GetMapping("/end")
    public String end() {
        return aopService.end();
    }

}
