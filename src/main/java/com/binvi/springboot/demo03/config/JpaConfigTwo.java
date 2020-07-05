package com.binvi.springboot.demo03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author binvi
 * @version 1.0
 * @Description: JPA配置多数据源二
 * @date 2019/6/11 22:22
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.binvi.springboot.demo03.repository2",
        //entityManagerFactoryRef = "entityManagerFactoryBeanTwo",
        //transactionManagerRef = "platformTransactionManagerTwo")
public class JpaConfigTwo {

    @Resource(name = "dsTwo")
    DataSource dsTwo;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dsTwo)
                .properties(jpaProperties.getProperties())
                .packages("com.binvi.springboot.demo03.entity")
                .persistenceUnit("pu2").build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBean = entityManagerFactoryBeanTwo(builder);
        return new JpaTransactionManager(factoryBean.getObject());
    }

}
