package com.binvi.springboot.demo03.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义拦截器
 * @date 2019/6/4 23:25
 */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        logger.info("-------------- preHandle --------------");
        logger.info("request:[{}]", request);
        logger.info("response:[{}]", response);
        logger.info("handler:[{}]", handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {
        logger.info("-------------- postHandle --------------");
        logger.info("request:[{}]", request);
        logger.info("response:[{}]", response);
        logger.info("handler:[{}]", handler);
        logger.info("modelAndView:[{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        logger.info("-------------- afterCompletion --------------");
        logger.info("request:[{}]", request);
        logger.info("response:[{}]", response);
        logger.info("handler:[{}]", handler);
        logger.info("Exception:[{}]", ex);
    }
}
