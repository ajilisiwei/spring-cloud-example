package com.wei.trace2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    private static Logger logger= LoggerFactory.getLogger(Application.class);

    @RequestMapping(value = "/trace-2",method = RequestMethod.GET)
    public String trace(){
        logger.info("--- call trace-2 ---");
        return "Test";
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
