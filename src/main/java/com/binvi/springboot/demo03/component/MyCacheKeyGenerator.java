package com.binvi.springboot.demo03.component;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义cache键key生成器
 * @date 2019/6/15 10:25
 */
@Component
public class MyCacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.toString())
                .append(method.getName())
                .append(Arrays.toString(params));
        return sb.toString();
    }
}
