package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.ShuValue;

import java.util.List;

public interface ShuValueService {
    List<ShuValue> queryAll(Integer attId);
}
