package com.binvi.springboot.demo03.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * @author binvi
 * @version 1.0
 * @Description: Mybatis配置mapper包扫描路径
 * @date 2019/6/11 16:29
 */
@Configuration
@MapperScan(basePackages = "com.binvi.springboot.demo03.mapper", annotationClass = Repository.class)
public class MyBatisConfig {

}
