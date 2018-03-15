package com.wei.serverprovider.controller;

import com.wei.serverprovider.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class HelloWorldController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello," + user.getName() + ", " + user.getAge();
    }

    @RequestMapping(value = "/hello4",method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        ServiceInstance instance=client.getLocalServiceInstance();
        int sleepTime=new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);
        logger.info("/hello4,host:"+instance.getHost()+", service_id:"+instance.getServiceId());
        return "hello world";
    }
}
