package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.User;
import com.fh.api.type.shop_type.service.UserService;
import com.fh.api.type.shop_type.utils.Md5Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("UserController")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("add")
    public Map add(User user){
        Map map=new HashMap();
        User u=userService.queryByName(user.getName());
        if (u==null){
            Date date=new Date();
            //创建时间
            user.setCreateDate(date);
            //密码加密
            String pass= Md5Utils.GetMD5Code(Md5Utils.GetMD5Code(user.getPassword()));
            user.setPassword(pass);
            userService.save(user);
            map.put("code",1);
        }else{
            map.put("code",2);
        }
        return  map;
    }
}
