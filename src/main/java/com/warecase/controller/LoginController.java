package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.User;
import com.warecase.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {

    // 自动注入IUserService
    @Resource
    private IUserService userService;

    /**
     * login
     * @param user user
     * @return AjaxResult
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user) {
        User tmpUser = this.userService.selectUserByUId(user.getUserId());
        if(tmpUser == null){
            return error("the user does not exist");
        }
        if(tmpUser.getPermission().equals(user.getPermission())
                &&tmpUser.getName().equals(user.getName())){
            return success("the user login success");
        }else{
            return error("the user login failed");
        }
    }

    /**
     * register
     * @param user user
     * @return AjaxResult
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user) {
        User tmpUser = this.userService.selectUserByUId(user.getUserId());
        if(tmpUser != null){
            return error("the user already exist");
        }else{
            int i = this.userService.insertUser(user);
            if(i == 1){
                return success("the user register success");
            }else{
                return error("the user register failed");
            }
        }
    }

}