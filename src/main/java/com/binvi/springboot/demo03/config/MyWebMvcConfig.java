package com.binvi.springboot.demo03.config;

import com.binvi.springboot.demo03.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author binvi
 * @version 1.0
 * @Description: web配置（全局）
 *      #addCorsMapping: 跨域配置
 *      #addInterceptors: 拦截器配置
 * @date 2019/6/3 23:25
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    // 配置cors跨域策略
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost:8081")
                .allowCredentials(false);
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/hello");
    }

    // 路径映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/unauthorized").setViewName("unauthorized");
    }


    // 配置fastjson解析转换器
    /*
        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
            FastJsonConfig config = new FastJsonConfig();
            config.setDateFormat("yyyy/MM/dd");
            config.setCharset(Charset.forName("UTF-8"));
            config.setSerializerFeatures(
                    SerializerFeature.WriteClassName,
                    SerializerFeature.WriteMapNullValue,
                    SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullStringAsEmpty
            );
            converter.setFastJsonConfig(config);
            converters.add(converter);
        }
    */

    // 配置静态资源访问策略
    /*
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("classpath:/static/");
        }
    */
}
