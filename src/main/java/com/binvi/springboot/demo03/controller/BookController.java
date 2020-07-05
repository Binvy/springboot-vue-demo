package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.component.Book;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/5/30 0:43
 */
@Controller
public class BookController {

    @GetMapping("books")
    public ModelAndView books() {
        List<Book> books = Lists.newArrayList();
        Book book1 = new Book();
        book1.setName("Thinking in Java");
        book1.setAuthor("tij");
        book1.setPrice(108f);

        Book book2 = new Book();
        book2.setName("Effective Java");
        book2.setAuthor("ej");
        book2.setPrice(100f);

        books.add(book1);
        books.add(book2);

        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }

    @GetMapping("book")
    public String book(Model model) {
        List<Book> books = Lists.newArrayList();
        books.add(new Book("Thinking in Java", "tij", 108f));
        books.add(new Book("Effective Java", "ej", 50f));
        books.add(new Book("Head First Java", "hfj", 20f));
        model.addAttribute("books", books);
        return "book";
    }

    @GetMapping("book/json")
    @ResponseBody
    public Book book() {
        return new Book("三国演义", "罗贯中", 100f);
    }

}
