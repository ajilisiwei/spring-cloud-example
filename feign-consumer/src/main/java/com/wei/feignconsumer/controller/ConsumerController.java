package com.wei.feignconsumer.controller;

import com.wei.feignconsumer.entity.User;
import com.wei.feignconsumer.service.HelloService;
import com.wei.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;
    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb=new StringBuilder();
        sb.append(helloService.hello("Tom")).append("\r\n");
        sb.append(helloService.hello("Jerry",3)).append("\r\n");
        sb.append(helloService.hello(new User("Jhon",22))).append("\r\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb=new StringBuilder();
        sb.append(refactorHelloService.hello("Tom")).append("\r\n");
        sb.append(refactorHelloService.hello("Jerry",3)).append("\r\n");
        sb.append(refactorHelloService.hello(new com.wei.dto.User("Jhon",22))).append("\r\n");
        return sb.toString();
    }

    @RequestMapping(value = "feign-consumer4",method = RequestMethod.GET)
    public String helloConstumer4(){
        return helloService.hello1();
    }
}
