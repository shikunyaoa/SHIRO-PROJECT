package com.kunyao.myshiro.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Slf4j
@Api("用户管理")
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @GetMapping("/test")
    @ApiOperation(value = "swagger test", notes = "swagger test", response = String.class)
    public Map<String, Object> test(){
        log.debug("swagger test");
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "测试成功");
        return map;
    }
}

