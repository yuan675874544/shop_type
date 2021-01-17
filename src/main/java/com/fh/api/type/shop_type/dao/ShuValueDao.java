package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShuValue;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShuValueDao {

    @Select("select * from t_shuvaluee  where attId=#{attId}")
    List<ShuValue> queryAll(Integer attId);
}
