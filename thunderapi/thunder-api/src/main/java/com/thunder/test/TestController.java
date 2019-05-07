package com.thunder.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@RestController
public class TestController {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/testDB")
    public String testDB(){
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        return dataSource.toString();
    }
}
