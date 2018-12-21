package com.qihong.demodubbomulticastconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DemoDubboMulticastConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboMulticastConsumerApplication.class, args);
    }

}

