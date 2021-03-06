package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.entity.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 22:06
 */
@Repository
public interface PatternDao extends JpaRepository<Pattern, String> {

}
