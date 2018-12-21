package com.qihong.demodubbomulticastconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qihong.demodubbomulticastapi.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/hello")
    public Object hello(String name){
        return helloService.hello(name);
    }
}
