package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.utils.QuanVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface QuanDao {
    @Update("update t_quanxian set isDel=1 where qid=#{qid}")
    void deleteIsdel(Integer qid);
    @Update("update  t_quanxian set  name=#{name},url=#{url},type=#{type},isDel=#{isDel}, " +
            "            CreateDate=#{CreateDate},author=#{author} where qid=#{qid}")
    void update(Quan quan);
    @Select("select * from t_quanxian  where qid=#{qid}")
    Map getDataByid(Integer qid);
    @Insert(" insert  into t_quanxian (name,url,type,isDel,CreateDate,author)\n" +
            "\n" +
            "  value(#{name},#{url},#{type},#{isDel},#{CreateDate},#{author})")
    void add(Quan quan);

    Integer queryCount(QuanVO vo);

    List<Quan> queryDataByVo(QuanVO vo);
}
