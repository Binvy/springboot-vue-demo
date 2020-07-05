package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义过滤器filter
 * @date 2019/6/9 14:29
 */
@WebFilter("/*")
public class MyFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("custom filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        logger.info("custom filter do filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("custom filter destroy");
    }
}
