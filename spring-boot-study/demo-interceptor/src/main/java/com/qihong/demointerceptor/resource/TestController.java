package com.qihong.demointerceptor.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/helloError")
    public String helloError(){
        int a=1/0;
        return "hello";
    }
}
