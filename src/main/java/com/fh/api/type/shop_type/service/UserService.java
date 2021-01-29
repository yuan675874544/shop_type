package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.User;

import java.util.Map;

public interface UserService {

    Map queryUser(User user);

    Map addUser(User user);
}
