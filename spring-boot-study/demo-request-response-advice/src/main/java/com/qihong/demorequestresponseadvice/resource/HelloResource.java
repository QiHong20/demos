package com.qihong.demorequestresponseadvice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public String hello(String name){
        return "hello "+name;
    }
    @PostMapping("/helloMap")
    public String helloMap(@RequestBody  Map map){
        return "hello "+map;
    }

}
