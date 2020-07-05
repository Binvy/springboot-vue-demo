package com.binvi.springboot.demo03.config;

import com.google.common.collect.Maps;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: 添加全局数据
 * @date 2019/6/7 22:10
 */
@ControllerAdvice
public class GlobalConfig {

    @ModelAttribute(value = "user")
    public Map<String, String> userInfo() {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("username", "曹雪芹");
        map.put("gender", "男");
        map.put("masterpiece", "红楼梦");
        return map;
    }

    // 表示该方法是处理@ModelAttribute("b")对应的参数
    @InitBinder("b")
    public void init(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }


    // 表示该方法是处理@ModelAttribute("a")对应的参数
    @InitBinder("a")
    public void init2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }

}
