package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.Quan;

import java.util.Map;

public interface QuanService {
    void deleteIsdel(Integer qid);

    void update(Quan quan);

    Map getDataByid(Integer qid);

    void add(Quan quan);
}
