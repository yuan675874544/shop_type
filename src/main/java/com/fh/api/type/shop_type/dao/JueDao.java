package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.utils.JueVO;

import java.util.List;

public interface JueDao {
    Integer queryCount(JueVO vo);

    List<JueSe> queryDataByVo(JueVO vo);
}
