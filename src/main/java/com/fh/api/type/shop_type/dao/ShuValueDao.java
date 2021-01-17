package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShuValue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShuValueDao {

    @Select("select * from t_shuvaluee  where attId=#{attId}")
    List<ShuValue> queryAll(Integer attId);
    @Delete("delete from t_shuvaluee where vid=#{vid}")
    void delValue(Integer id);
    @Insert("insert  into  t_shuvaluee (name,nameCH) value(#{name},#{nameCH})")
    void add(ShuValue shuValue);
}
