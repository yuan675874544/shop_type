package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.utils.ShuVO;

import java.util.List;
import java.util.Map;

public interface ShuService {
    Map queryShuData(ShuVO vo);

    void deleteIsdel(Integer sid);

    Map getDataByid(Integer sid);

    void update(ShuXing shuXing);

    void add(ShuXing shuXing);

    List<ShuXing> queryDataByTypeId(Integer typeId);

   Map queryDatasType(Integer typeId);
}
