package com.binvi.springboot.demo03.controller;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/16 22:25
 */

import com.binvi.springboot.demo03.entity.UserLogin;
import com.binvi.springboot.demo03.repository.UserLoginDao;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RestController
public class ShiroController {

    private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);

    @Autowired
    private UserLoginDao userLoginDao;

    @PostMapping("doLogin")
    public ModelAndView doLogin(String username, String password, Model model) {
        logger.info("ShiroController doLogin start, username:[{}], password:[{}]", username, password);
        /*UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            model.addAttribute("error", "用户名和密码输入错误");
            return "login";
        }*/
        UserLogin userLogin = userLoginDao.findByUsername(username);
        if (Objects.isNull(userLogin)) {
            model.addAttribute("error", "用户名不存在");
            return new ModelAndView("login");
        }
        logger.info("userLogin = {}", userLogin);
        if (!StringUtils.equals(password, userLogin.getPassword())) {
            model.addAttribute("error", "密码不正确");
            return new ModelAndView("login");
        }
        return new ModelAndView("index");
    }

    /*@RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin() {
        logger.info("ShiroController admin start");
        return "admin";
    }

    @RequiresRoles(value = {"admin", "user"}, logical = Logical.OR)
    public String user() {
        logger.info("ShiroController admin start");
        return "user";
    }*/

}
