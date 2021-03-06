package com.example.configclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//自动刷新.
public class ConfigClientController {
    //这个@Value会根据配置的配置中心地址找到git仓库对应的配置和本地服务的配置文件
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.rabbitmq.port}")
    private String rabbitPort;

    //配置中心的与本spring.application.name-{gitbranch}.properties文件中没有下面的属性,注入会失败.
//    @Value("${zuul.routes.api-a.serviceId}")
//    private String defaultZone;
    @Value("${foo}")
    private String foo;
    @Value("${spring.rabbitmq.textPort}")//测试本地application.properties能否使用.
    private int rabbitTestPort;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigClientController.class);
    @GetMapping("/testConfig")
    public String test(){
        LOGGER.info("从配置中心读取到的配置:serverPort:{},rabbitPort:{},foo:{}",
                serverPort,rabbitPort,foo);
        return "读取到配置中心,被覆盖的server.port端口配置："
                +serverPort+",配置中心未覆盖的foo:"+foo
                +",rabbitPort:"+rabbitPort
                +"rabbitTestPort:"+rabbitTestPort;
    }
}
