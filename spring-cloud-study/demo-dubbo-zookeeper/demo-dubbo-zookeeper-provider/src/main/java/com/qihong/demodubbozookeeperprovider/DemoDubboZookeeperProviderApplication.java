package com.qihong.demodubbozookeeperprovider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DemoDubboZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboZookeeperProviderApplication.class, args);
    }

}

