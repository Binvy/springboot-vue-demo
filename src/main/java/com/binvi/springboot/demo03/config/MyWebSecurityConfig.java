package com.binvi.springboot.demo03.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author binvi
 * @version 1.0
 * @Description: Security基本配置
 * @date 2019/6/15 16:16
 */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(MyWebSecurityConfig.class);

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("$2a$10$OciW5kufXqinS71A0m4IGubMH/Y2pR1jFJtudpU.HWBWnlSrxFxZC").roles("ADMIN", "DBA")
                .and()
                .withUser("admin").password("$2a$10$blchBa/QrzI8RLYStHCwAucY0Oc/ZeNvUdlY/QW8SFp9xsvN3Oz76").roles("ADMIN", "USER")
                .and()
                .withUser("binvi").password("$2a$10$jlzI.D3qy1e8ZMTpAmr1eeo9QQB73cCdPw7MScYVB3uhLvF5yzj4.").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN', 'USER')")
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login_page")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((request, response, authentication) -> {
                    logger.info("AuthenticationSuccessHandler onAuthenticationSuccess start");
                    Object principal = authentication.getPrincipal();
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    response.setStatus(HttpStatus.OK.value());
                    HashMap<String, Object> map = Maps.newHashMap();
                    map.put("status", HttpStatus.OK.value());
                    map.put("message", principal);
                    ObjectMapper objectMapper = new ObjectMapper();
                    writer.write(objectMapper.writeValueAsString(map));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((request, response, exception) -> {
                    logger.info("AuthenticationSuccessHandler onAuthenticationFailure start");
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    HashMap<String, Object> map = Maps.newHashMap();
                    map.put("status", HttpStatus.UNAUTHORIZED.value());
                    map.put("message", exception instanceof LockedException ? "账户被锁定，登陆失败！"
                            : exception instanceof BadCredentialsException ? "账户名或密码输入错误，登陆失败！"
                            : exception instanceof DisabledException ? "账户被禁用，登陆失败！"
                            : exception instanceof AccountExpiredException ? "账户已过期，登陆失败！"
                            : exception instanceof CredentialsExpiredException ? "密码已过期，登陆失败！"
                            : "登陆失败！");
                    ObjectMapper objectMapper = new ObjectMapper();
                    writer.write(objectMapper.writeValueAsString(map));
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler((request, response, authentication) -> {
                    // 推出登陆时的一些数据清除工作
                    logger.info("LogoutHandler logout start");
                })
                .logoutSuccessHandler((request, response, authentication) -> {
                    logger.info("LogoutSuccessHandler onLogoutSuccess start");
                    response.sendRedirect("/login_page");
                })
                .and()
                .csrf()
                .disable();
    }

}
