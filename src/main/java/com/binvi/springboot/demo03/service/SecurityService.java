package com.binvi.springboot.demo03.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author binvi
 * @version 1.0
 * @Description: 安全配置测试Service
 * @date 2019/6/15 19:05
 */
@Service
public class SecurityService {

    @Secured("ROLE_ADMIN")
    public String admin() {
        return "hello admin";
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('DBA')")
    public String dba() {
        return "hello dba";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'DBA', 'USER')")
    public String user() {
        return "hello user";
    }

}
