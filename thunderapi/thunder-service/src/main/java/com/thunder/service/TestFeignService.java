package com.thunder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "THUNDER-API")
public interface TestFeignService {

    @RequestMapping("/hello")
    String hello(@RequestParam("name") String name);
}
