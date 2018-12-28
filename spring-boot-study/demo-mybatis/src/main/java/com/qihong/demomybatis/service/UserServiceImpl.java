package com.qihong.demomybatis.service;

import com.qihong.demomybatis.dto.User;
import com.qihong.demomybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User add(User user) {
        int id=userMapper.insert(user);
        return user;
    }
}
