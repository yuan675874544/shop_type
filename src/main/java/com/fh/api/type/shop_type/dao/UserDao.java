package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.User;

public interface UserDao {
    User queryByName(String name);

    void save(User user);
}
