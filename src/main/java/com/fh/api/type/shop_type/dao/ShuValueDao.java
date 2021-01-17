package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShuValue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ShuValueDao {

    @Select("select * from t_shuvaluee  where isDel=0 and attId=#{attId}")
    List<ShuValue> queryAll(Integer attId);
    @Insert("insert  into  t_shuvaluee (name,nameCH,attId) value(#{name},#{nameCH},#{attId})")
    void add(ShuValue shuValue);
    @Select("select * from t_shuvaluee  where vid=#{vid}")
    Map getDataByid(Integer vid);
    @Update("update  t_shuvaluee set name=#{name},nameCH=#{nameCH} where vid=#{vid}")
    void update(ShuValue shuValue);
    @Update("update t_shuvaluee set isDel=1 where vid=#{vid}")
    void deleteIsdel(Integer vid);
}
