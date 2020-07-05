package com.binvi.springboot.demo03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description: security相关控制器
 * @date 2019/6/15 16:29
 */
@RestController
public class SecurityController {

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba";
    }

    @GetMapping("/security/hello")
    public String security() {
        return "hello security";
    }

}
