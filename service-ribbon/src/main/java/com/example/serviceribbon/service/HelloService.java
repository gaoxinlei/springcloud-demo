package com.example.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(String name){
        return restTemplate.getForObject("http://eureka-provider/hello?name="+name,String.class);
    }

    public String helloFallback(String name){
        return "hi sorry,error occurs:"+name;
    }
}
