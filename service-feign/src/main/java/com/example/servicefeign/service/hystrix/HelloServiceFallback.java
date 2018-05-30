package com.example.servicefeign.service.hystrix;

import com.example.servicefeign.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello(String name) {
        return "Hi sorry ,service not valid now :"+name;
    }
}
