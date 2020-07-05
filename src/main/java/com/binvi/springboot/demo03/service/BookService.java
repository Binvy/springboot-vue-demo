package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.component.Book;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/2 17:11
 */
public interface BookService {

    List<Book> generateEnBooks();

    List<Book> generateCnBooks();

}
