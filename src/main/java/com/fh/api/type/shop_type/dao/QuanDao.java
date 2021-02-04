package com.fh.api.type.shop_type.dao;

import org.apache.ibatis.annotations.Update;

public interface QuanDao {
    @Update("update t_quanxian set isDel=1 where qid=#{qid}")
    void deleteIsdel(Integer qid);
}
