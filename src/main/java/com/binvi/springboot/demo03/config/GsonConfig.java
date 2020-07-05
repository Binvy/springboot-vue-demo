package com.binvi.springboot.demo03.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义GSON转换类（需先将org.springframework.boot:spring-boot-starter-web中的com.fasterxml.jackson.core:jackson-databind依赖包移除）
 * @date 2019/6/7 9:39
 */
@Configuration
public class GsonConfig {

    //@Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
        Gson gson = builder.create();
        converter.setGson(gson);
        return converter;
    }

}
