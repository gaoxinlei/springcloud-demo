package com.example.servicefeign.controller;

import com.example.servicefeign.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return helloService.hello(name);
    }
}
