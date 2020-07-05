package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.component.Book;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: freemarker控制器
 * @date 2019/6/2 16:54
 */
@Controller
public class FreeMarkerController {

    @RequestMapping("book/ftl")
    public ModelAndView ftl() {
        List<Book> books = Lists.newArrayList();
        books.add(new Book("JVM", "jvm", 108f));
        books.add(new Book("Docker", "docker", 50f));
        books.add(new Book("Linux", "linux", 20f));
        books.add(new Book("Tomcat", "tomcat", 70f));
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("bookftl");
        return mv;
    }

}
