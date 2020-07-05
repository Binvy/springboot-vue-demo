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
 * @Description: JPA配置多数据源一
 * @date 2019/6/11 22:22
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.binvi.springboot.demo03.repository1",
        //entityManagerFactoryRef = "entityManagerFactoryBeanOne",
        //transactionManagerRef = "platformTransactionManagerOne")
public class JpaConfigOne {

    @Resource(name = "dsOne")
    DataSource dsOne;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dsOne)
                .properties(jpaProperties.getProperties())
                .packages("com.binvi.springboot.demo03.entity")
                .persistenceUnit("pu1").build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBean = entityManagerFactoryBeanOne(builder);
        return new JpaTransactionManager(factoryBean.getObject());
    }

}
