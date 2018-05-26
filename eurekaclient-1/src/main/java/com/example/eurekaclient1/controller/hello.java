package com.example.eurekaclient1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @Value("${server.port}")
    private int port;
    @GetMapping("/hello")
    public String hi(String name){
        return "hello :"+name+",port:"+port;
    }
}
