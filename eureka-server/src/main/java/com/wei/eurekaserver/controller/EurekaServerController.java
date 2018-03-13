package com.wei.eurekaserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServerController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World xx";
    }
}
