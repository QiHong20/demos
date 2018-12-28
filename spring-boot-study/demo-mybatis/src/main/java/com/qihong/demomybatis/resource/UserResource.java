package com.qihong.demomybatis.resource;

import com.qihong.demomybatis.dto.User;
import com.qihong.demomybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("user/add")
    public User saveUser(String name){
        User user=new User();
        user.setName(name);
        return  userService.add(user);

    }
}
