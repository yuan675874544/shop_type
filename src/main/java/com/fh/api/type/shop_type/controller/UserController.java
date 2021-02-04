package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.User;
import com.fh.api.type.shop_type.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("UserController")
public class UserController {

    @Resource
    public UserService userService;

    /*登录*/
    @PostMapping("queryUser")
    public Map queryUser(User  user){
        Map map=userService.queryUser(user);
        return map;
    }

    /*注册用户*/
    @PostMapping("addUser")
    public Map addUser(User user){
        Map map=userService.addUser(user);
        return map;
    }

}
