package com.thunder.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
    @RabbitListener(queues = "thunder.mq1")
    public String executeHello(String name){
        System.out.println("RABBIT GET :" + name);
        return name + " say Hello";
    }

}
