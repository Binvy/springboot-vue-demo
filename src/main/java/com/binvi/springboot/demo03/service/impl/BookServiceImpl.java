package com.binvi.springboot.demo03.service.impl;

import com.binvi.springboot.demo03.component.Book;
import com.binvi.springboot.demo03.service.BookService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/2 17:12
 */
@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public List<Book> generateEnBooks() {
        logger.info("generate english books");
        List<Book> books = Lists.newArrayListWithCapacity(5);
        books.add(new Book("Spring", "spring", 108f));
        books.add(new Book("Struts", "struts", 20f));
        books.add(new Book("Mybatis", "mybatis", 50f));
        books.add(new Book("Hibernate", "hibernate", 50f));
        books.add(new Book("SpringMVC", "spring-mvc", 50f));
        return books;
    }

    @Override
    public List<Book> generateCnBooks() {
        logger.info("generate chinese books");
        List<Book> books = Lists.newArrayListWithCapacity(4);
        books.add(new Book("《红楼梦》", "曹雪芹+高鹗", 100f));
        books.add(new Book("《西游记》", "吴承恩", 100f));
        books.add(new Book("《三国演义》", "罗贯中", 100f));
        books.add(new Book("《水浒传》", "施耐庵", 100f));
        return books;
    }
}
