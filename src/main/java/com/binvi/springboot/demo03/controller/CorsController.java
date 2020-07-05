package com.binvi.springboot.demo03.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/3 23:07
 */
@RestController
@RequestMapping("/cors")
public class CorsController {

    @PostMapping("/add")
    // @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name) {
        return "receive:" + name;
    }

    @DeleteMapping("/{id}")
    // @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String deleteById(@PathVariable Long id) {
        return String.valueOf(id);
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cors");
        return mv;
    }

}
