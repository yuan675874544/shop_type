package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.User;

public interface UserDao {

    void addUser(User user);

    User queryUsername(String name);
}
