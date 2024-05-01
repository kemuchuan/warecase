package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.User;
import com.warecase.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提供给前端的接口
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    // 注入service层
    @Resource
    private IUserService userService;

    /**
     * 查询用户信息列表
     * @param user 用户信息
     * @return 用户信息列表
     */
    @GetMapping("/list")
    public AjaxResult listUsers(User user){
        return success(this.userService.listUsers(user));
    }

    /**
     * 根据用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    @GetMapping("/{userId}")
    public AjaxResult getUser(@PathVariable("userId") String userId){
        return success(this.userService.selectUserByUId(userId));
    }

    /**
     * 查询所有的用户信息
     * @return 所有用户信息
     */
    @GetMapping
    public AjaxResult getAllUser(){
        return success(this.userService.selectAllUsers());
    }

    /**
     * 新增用户信息
     * @param user 用户信息
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult addUser(@RequestBody User user){
        return toAjax(this.userService.insertUser(user));
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 更新结果
     */
    @PutMapping
    public AjaxResult updateUser(@RequestBody User user){
        return toAjax(this.userService.updateUser(user));
    }

    /**
     * 删除用户信息
     * @param userId 用户id
     * @return 删除结果
     */
    @DeleteMapping("/{userId}")
    public AjaxResult deleteUser(@PathVariable("userId") String userId){
        return toAjax(this.userService.deleteUserByUserId(userId));
    }

}
