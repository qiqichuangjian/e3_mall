package com.chinasofti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 张晋飞
 * date : 2019/4/23
 */
@RestController
public class HelloController {

    @RequestMapping("/hello123")
    public String hello(){

        return "haha,你在干嘛！";
    }
}
