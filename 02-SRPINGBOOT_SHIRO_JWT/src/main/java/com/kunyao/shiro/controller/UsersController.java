package com.kunyao.shiro.controller;

import com.kunyao.shiro.config.ResponseHelper;
import com.kunyao.shiro.config.ResponseModel;
import com.kunyao.shiro.entity.UsersEntity;
import com.kunyao.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UsersController
 * @Author: kunyao
 * @Description: 用户认证模块
 * @Date: 2020/3/20 21:47
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sys/user")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseModel<UsersEntity> login(@RequestBody UsersEntity usersEntity) throws Exception{
        return ResponseHelper.buildResponseModel(userService.login(usersEntity));
    }
}
