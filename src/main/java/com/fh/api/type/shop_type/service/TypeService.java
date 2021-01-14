package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.ShopType;

import java.util.Map;

public interface TypeService {

    Map getDataByPid(Integer pid);


    Integer add(ShopType shopType);

    Map getDataByid(Integer id);

    void update(ShopType shopType);

    Map queryData();
}
