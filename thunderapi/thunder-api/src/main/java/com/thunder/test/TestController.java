package com.thunder.test;

import com.thunder.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestFeignService testFeignService;


    @RequestMapping("/test")
    public String testDB(){
        return "hello";
    }

    @RequestMapping("/testFeigh")
    public String testFeign(){
        return testFeignService.hello("ZYX");
    }
}
