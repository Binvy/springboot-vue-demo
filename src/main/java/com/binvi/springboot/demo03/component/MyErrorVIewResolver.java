package com.binvi.springboot.demo03.component;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义Error视图
 * @date 2019/6/9 11:20
 */
@Component
public class MyErrorVIewResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request,
                                         HttpStatus status, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView("errorPage");
        mv.addObject("ester_eggs", "I am iron man");
        mv.addAllObjects(model);
        return mv;
    }
}
