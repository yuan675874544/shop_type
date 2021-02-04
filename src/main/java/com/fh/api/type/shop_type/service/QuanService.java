package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.Quan;

public interface QuanService {
    void deleteIsdel(Integer qid);

    void update(Quan quan);
}
