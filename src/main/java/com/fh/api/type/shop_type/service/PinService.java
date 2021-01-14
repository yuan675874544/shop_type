package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.utils.PinVO;

import java.util.Map;

public interface PinService {
    Map queryPinDataPage(PinVO vo);

    void add(Pin pin);

    Map getDataByid(Integer id);

    void update(Pin pin);

    void deleteIsdel(Integer iid);
}
