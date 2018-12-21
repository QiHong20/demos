package com.qihong.demodubbomulticastprovider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DemoDubboMulticastProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboMulticastProviderApplication.class, args);
    }

}

