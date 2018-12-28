package com.qihong.demoresttemplate.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MockResource {

    @PostMapping("/hello")
    public Object hello(@RequestBody Map map){
        return "hello"+map;
    }
}
