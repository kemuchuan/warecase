package com.warecase.service.impl;

import com.warecase.mapper.UserMapper;
import com.warecase.pojo.User;
import com.warecase.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service层实现类
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listUsers(User user) {
        return this.userMapper.listUsers(user);
    }

    @Override
    public User selectUserByName(String name) {
        return this.userMapper.selectUserByName(name);
    }

    @Override
    public User selectUserByUId(String userId) {
        return this.userMapper.selectUserByUId(userId);
    }

    @Override
    public int insertUser(User user) {
        return this.userMapper.insertUser(user);
    }

    @Override
    public int deleteUserByUserId(String userId) {
        return this.userMapper.deleteUserByUserId(userId);
    }

    @Override
    public int updateUser(User user) {
        return this.userMapper.updateUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userMapper.selectAllUsers();
    }
}
