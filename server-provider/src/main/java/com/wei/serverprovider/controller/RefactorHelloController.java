package com.wei.serverprovider.controller;

import com.wei.dto.User;
import com.wei.service.IHelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements IHelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(User user) {
        return "Hello, "+user.getName()+", "+user.getAge();
    }
}
