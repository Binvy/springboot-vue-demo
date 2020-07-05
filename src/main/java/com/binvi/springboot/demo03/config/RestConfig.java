package com.binvi.springboot.demo03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * @author binvi
 * @version 1.0
 * @Description: Rest相关配置（优先级高于配置文件application.properties）
 * @date 2019/6/12 23:36
 */
@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultPageSize(10)           // 每页默认记录数，默认20
                .setPageParamName("page")       // 分页查询页码参数名，默认值为page
                .setLimitParamName("size")      // 分页查询记录数参数名，默认为size
                .setSortParamName("sort")       // 分页查询排序参数名，默认值为sort
                //.setBasePath("/api")          // 表示给所有请求路径都加上前缀
                .setReturnBodyOnCreate(true)    // 添加成功时是否返回添加内容
                .setReturnBodyOnUpdate(true);   // 更新成功时是否返回更新内容
    }

}
