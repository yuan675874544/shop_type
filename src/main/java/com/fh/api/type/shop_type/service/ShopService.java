package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.Shop;

import java.util.Map;

public interface ShopService {
    void add(Shop shop);

    void deleteIsdel(Integer shopId);

    Map getDataByid(Integer shopId);
}
