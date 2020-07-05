package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/2 17:08
 */
@Controller
@RequestMapping("/template/book")
public class TemplateController {

    @Autowired
    BookService bookService;

    @GetMapping("/thymeleaf")
    public ModelAndView thymeleaf() {
        return this.generateMV("thymeleaf");
    }

    @GetMapping("/freemarker")
    public ModelAndView freemarker() {
        return this.generateMV("freemarker");
    }

    @GetMapping("/velocity")
    public ModelAndView velocity() {
        return this.generateMV("velocity");
    }

    public ModelAndView generateMV(String viewname) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", bookService.generateCnBooks());
        mv.setViewName(viewname);
        return mv;
    }

}
