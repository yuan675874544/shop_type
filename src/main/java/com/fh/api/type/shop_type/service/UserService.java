package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.User;

import java.util.Map;

public interface UserService {
    User queryByName(String name);

    void save(User user);

}
