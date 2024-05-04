package com.warecase.mapper;

import com.warecase.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * UserMapper接口，定义了对user表的增删改查操作
 */
public interface UserMapper {

    /**
     * 根据条件查询用户列表
     * @param user 用户对象
     * @return 用户列表
     */
    List<User> listUsers(User user);

    /**
     * 根据用户name查询用户
     * @param name 用户name
     * @return 用户对象
     */
    @Select("select user_id,name,permission,password from user where name = #{name}")
    User selectUserByName(String name);

    /**
     * 根据userId查询用户
     * @param userId 用户id
     * @return 用户对象
     */
    @Select("select user_id,name,permission,password from user where user_id = #{userId}")
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
    @Delete("delete from user where user_id = #{userId};")
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
    @Select("select user_id,name,permission from user")
    List<User> selectAllUsers();
}
