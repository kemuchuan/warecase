package com.warecase.service;

import com.warecase.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserService {

    /**
     * 查询用户列表
     * @param user 用户对象
     * @return 用户列表
     */
    List<User> listUsers(User user);

    /**
     * 根据用户name查询用户
     */
    User selectUserByName(String name);

    /**
     * 根据userId查询用户
     * @param userId 用户id
     * @return 用户对象
     */
    User selectUserByUId(String userId);

    /**
     * 插入用户信息
     * @param user 用户对象
     * @return 影响的行数
     */
    int insertUser(User user);

    /**
     * 删除用户信息
     * @param userId 用户id
     * @return 影响的行数
     */
    int deleteUserByUserId(String userId);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 影响的行数
     */
    int updateUser(User user);

    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    List<User> selectAllUsers();

}
