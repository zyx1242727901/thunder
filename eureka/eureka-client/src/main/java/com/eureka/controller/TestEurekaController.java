package com.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEurekaController {

    @RequestMapping("hello")
    public String hello (String name){
        return "hello " + name;
    }
}
