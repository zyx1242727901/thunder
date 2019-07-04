package com.thunder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "THUNDER-EUREKA")
public interface TestFeignService {

    @RequestMapping("/hello")
    String hello(@RequestParam("name") String name);
}
