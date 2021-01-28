package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.UserDao;
import com.fh.api.type.shop_type.model.User;
import com.fh.api.type.shop_type.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryByName(String name) {
        return userDao.queryByName(name);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

}
