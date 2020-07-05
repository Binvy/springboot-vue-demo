package com.binvi.springboot.demo03.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义Error数据
 * @date 2019/6/8 11:24
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> attributes = super.getErrorAttributes(webRequest, includeStackTrace);
        attributes.put("custom", "who am i");
        attributes.put("special", "old boy");
        attributes.put("goal", "just do it");
        return attributes;
    }
}
