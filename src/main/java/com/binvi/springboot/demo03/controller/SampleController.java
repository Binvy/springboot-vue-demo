package com.binvi.springboot.demo03.controller;

import com.binvi.springboot.demo03.component.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/7 8:33
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("")
    public Sample query() {
        return Sample.of();
    }

}
