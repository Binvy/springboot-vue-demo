package com.binvi.springboot.demo03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author binvi
 * @version 1.0
 * @Description: 多个HttpSecurity配置
 * @date 2019/6/15 18:35
 */
//@Configuration
public class MultiHttpSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("$2a$10$OciW5kufXqinS71A0m4IGubMH/Y2pR1jFJtudpU.HWBWnlSrxFxZC").roles("ADMIN", "DBA")
                .and()
                .withUser("admin").password("$2a$10$blchBa/QrzI8RLYStHCwAucY0Oc/ZeNvUdlY/QW8SFp9xsvN3Oz76").roles("ADMIN", "USER")
                .and()
                .withUser("binvi").password("$2a$10$jlzI.D3qy1e8ZMTpAmr1eeo9QQB73cCdPw7MScYVB3uhLvF5yzj4.").roles("USER");
    }

    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**").authorizeRequests().anyRequest().hasRole("ADMIN");
        }
    }

    public static class OtherSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/login")
                    .permitAll()
                    .and()
                    .csrf()
                    .disable();
        }
    }

}
