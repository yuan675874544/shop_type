package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.ShuValue;

import java.util.List;
import java.util.Map;

public interface ShuValueService {
    List<ShuValue> queryAll(Integer attId);


    void add(ShuValue shuValue);

    Map getDataByid(Integer vid);

    void update(ShuValue shuValue);

    void deleteIsdel(Integer vid);
}
