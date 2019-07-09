package com.thunder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RabbitmqApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApiApplication.class, args);
    }

}
