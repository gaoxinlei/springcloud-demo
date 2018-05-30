package com.example.servicefeign.service;

import com.example.servicefeign.service.hystrix.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-PROVIDER",fallback = HelloServiceFallback.class)
public interface HelloService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
