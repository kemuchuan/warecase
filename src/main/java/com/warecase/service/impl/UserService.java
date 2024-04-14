package com.warecase.service.impl;

import com.warecase.mapper.UserMapper;
import com.warecase.pojo.User;
import com.warecase.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }



}
