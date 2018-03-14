package com.wei.feignconsumer.service;

import com.wei.service.IHelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends IHelloService{
}
