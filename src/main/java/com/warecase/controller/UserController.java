package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @GetMapping("/user/{uid}")
    public AjaxResult getUser(@PathVariable("uid") Integer uid){

        return success(this.userService.selectUserByUid(uid));
    }

}
