package com.thunder.test;

import com.thunder.service.TestFeignService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestFeignService testFeignService;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("/test")
    public String testDB(){
        return "hello";
    }

    @RequestMapping("/testFeigh")
    public String testFeign(){
        return testFeignService.hello("ZYX");
    }

    @RequestMapping("/testRabbit")
    public String testRabbit(String name){
        Object sendAndReceive = rabbitTemplate.convertSendAndReceive("te1", "mq1.key", name);
        return sendAndReceive.toString();
    }
}
