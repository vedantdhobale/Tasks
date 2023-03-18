package com;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    
    @Autowired
    private QueryService queryService;
    
 
    @Override
    public void run(String... args) throws Exception {

      

        logger.info("All users -> {}", queryService.getQueryReport("Select * from employees"));
        logger.info("All users -> {}", queryService.getQueryReport("Select * from department"));
    }  

    
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
