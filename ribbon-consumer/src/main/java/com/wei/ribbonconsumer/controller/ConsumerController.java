package com.wei.ribbonconsumer.controller;

import com.wei.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

//    00.没有使用hystrix
//    @Autowired
//    RestTemplate restTemplate;

    //01.使用hystrix
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer",method= RequestMethod.GET)
    public String helloConsumer(){
//    00.没有使用hystrix
//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        return helloService.helloService();
    }
}
