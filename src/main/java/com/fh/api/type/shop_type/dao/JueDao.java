package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.utils.JueVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface JueDao {
    Integer queryCount(JueVO vo);

    List<JueSe> queryDataByVo(JueVO vo);
    @Insert(" insert  into t_juese (name,isDel,CreateDate,author)\n" +
            "\n" +
            "  value(#{name},#{isDel},#{CreateDate},#{author})")
    void add(JueSe jueSe);
}
