package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShuDao {
    Integer queryCount(ShuVO vo);

    List<ShuXing> queryDataByVo(ShuVO vo);
    @Update("update t_shuxing set isDel=1 where sid=#{sid}")
    void deleteIsdel(Integer sid);
}
