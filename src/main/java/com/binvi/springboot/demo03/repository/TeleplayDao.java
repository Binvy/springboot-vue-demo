package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.entity.Teleplay;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/12 18:11
 */
public interface TeleplayDao extends MongoRepository<Teleplay, Integer> {

    List<Teleplay> findByAuthorContains(String author);

    List<Teleplay> findByNameEquals(String name);

}
