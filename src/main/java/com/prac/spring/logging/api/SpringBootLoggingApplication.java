package com.prac.spring.logging.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLoggingApplication
{
    Logger logger = LoggerFactory.getLogger(SpringBootLoggingApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootLoggingApplication.class, args);
    }

    @GetMapping("test/{name}")
    public String getting(@PathVariable String name)
    {
        logger.debug("Input {}",name);

        if(name.equals("aman")){
            throw new RuntimeException("Oops ....");
        }
        String response ="Hi "+name+"keep practicing spring boot";
        logger.debug("Output {}",response);
        return response;
    }
}
