package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.utils.JueVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface JueDao {
    Integer queryCount(JueVO vo);

    List<JueSe> queryDataByVo(JueVO vo);
    @Insert(" insert  into t_juese (name,isDel,CreateDate,author)\n" +
            "\n" +
            "  value(#{name},#{isDel},#{CreateDate},#{author})")
    void add(JueSe jueSe);
    @Update("update t_juese set isDel=1 where jid=#{jid}")
    void deleteIsdel(Integer jid);
    @Select("select * from t_juese  where jid=#{jid}")

    Map getDataByid(Integer jid);
}
