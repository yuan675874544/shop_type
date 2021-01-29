package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.UserDao;
import com.fh.api.type.shop_type.model.User;
import com.fh.api.type.shop_type.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Map addUser(User user) {
        Map map=new HashMap();
        if (user!=null){
            map.put("code",400);
            map.put("message","对象为空");
        }
        user.setUpdateDate(new Date());
        user.setCreateDate(new Date());
        userDao.addUser(user);
        map.put("code",200);
        map.put("message","注册成功");
        return map;
    }

    @Override
    public Map queryUser(User user) {
        Map map=new HashMap();
        User user1=userDao.queryUsername(user.getName());
        if (user1!=null){
            if(user1.getPassword().equals(user.getPassword())){
                map.put("code",200);
                map.put("message","成功登录");
            }else{
                map.put("code",402);
                map.put("message","密码不正确");
            }
        }else{
            map.put("code",400);
            map.put("message","用户不存在");
        }
        return map;
    }
}
