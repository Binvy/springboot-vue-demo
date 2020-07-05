package com.binvi.springboot.demo03;

import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Repository;

import javax.jms.Queue;

@SpringBootApplication //(exclude = {SecurityAutoConfiguration.class})
@ServletComponentScan // 实现对servlet、filter、listener的扫描
//@MapperScan(basePackages = "com.binvi.springboot.demo03.mapper", annotationClass = Repository.class)
//@EnableRedisHttpSession
@EnableCaching
@EnableScheduling
@EnableBatchProcessing
public class Demo03Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo03Application.class, args);
    }

    @Bean
    Queue queue() {
        return new ActiveMQQueue("amq");
    }

}
