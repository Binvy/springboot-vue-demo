package com.binvi.springboot.demo03.config;

import com.binvi.springboot.demo03.component.CustomAccessDecisionManager;
import com.binvi.springboot.demo03.component.CustomFilterInvocationSecurityMetadataSource;
import com.binvi.springboot.demo03.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author binvi
 * @version 1.0
 * @Description: 基于数据库的认证
 * @date 2019/6/15 20:59
 */
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserLoginService userLoginService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_dba > ROLE_admin ROLE_admin > ROLE_user";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userLoginService);
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$PPIuveym0ySME6ntdZ99mezqO72yecT42pAUooeKgqCOz.w7RkqWi")
                //.password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqiXzbz50dceRsga.WYiq")
                .roles("admin")
                .and()
                .withUser("binvi")
                .password("$2a$10$vBv5rA.DlLUQCVdpDh6f6ejVP2XQW0R4aEuUDsikK6otkMJsQWYX6")
                //.password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqiXzbz50dceRsga.WYiq")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* 常规权限配置 */
        /*
            http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/db/**").hasRole("dba")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .and()
                .csrf().disable();
        */

        /* 动态配置权限 */
        /*
            http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(customFIlterInvocationSecurityMetadataSource());
                        object.setAccessDecisionManager(customAccessDecisionManager());
                        return object;
                    }
                })
                .and()
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .and()
                .csrf().disable();
        */

        /* OAuth配置 */
        http.authorizeRequests()
                .antMatchers("/oauth/**")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    CustomFilterInvocationSecurityMetadataSource cfisms() {
        return new CustomFilterInvocationSecurityMetadataSource();
    }

    @Bean
    CustomAccessDecisionManager cadm() {
        return new CustomAccessDecisionManager();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
