package com.binvi.springboot.demo03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/2 15:43
 */
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world")String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
