package com.qihong.demodubbomulticastprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qihong.demodubbomulticastapi.service.HelloService;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements  HelloService{
    @Override
    public String hello(String name) {
        return "hello "+name;
    }
}
