package com.qihong.demodubbozookeeperconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DemoDubboZookeeperConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboZookeeperConsumerApplication.class, args);
    }

}

