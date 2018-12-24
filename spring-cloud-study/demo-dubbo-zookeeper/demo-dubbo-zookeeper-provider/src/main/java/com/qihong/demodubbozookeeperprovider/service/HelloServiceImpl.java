package com.qihong.demodubbozookeeperprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qihong.demodubbozookeeperapi.service.HelloService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello "+name;
    }
}
