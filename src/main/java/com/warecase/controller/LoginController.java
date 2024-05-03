package com.warecase.controller;

import com.warecase.constant.HttpStatus;
import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.User;
import com.warecase.service.IUserService;
import com.warecase.util.token.TokenService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {

    // 自动注入IUserService
    @Resource
    private IUserService userService;

    @Resource
    private TokenService tokenService;

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
        if(tmpUser.getPassword().equals(user.getPassword())){
            String token = tokenService.getToken(tmpUser.getUserId(),tmpUser.getPermission());
            AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS, "the user login success");
            ajaxResult.put("token",token);
            ajaxResult.put("permission",tmpUser.getPermission());
            return ajaxResult;
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
