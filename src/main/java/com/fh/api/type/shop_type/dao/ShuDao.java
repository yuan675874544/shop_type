package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ShuDao {
    Integer queryCount(ShuVO vo);

    List<ShuXing> queryDataByVo(ShuVO vo);
    @Update("update t_shuxing set isDel=1 where sid=#{sid}")
    void deleteIsdel(Integer sid);
    @Select("select * from t_shuxing  where sid=#{sid}")
    Map getDataByid(Integer sid);
    @Update("update t_shuxing set  name=#{name},nameCH=#{nameCH},typeId=#{typeId},type=#{type}, " +
            "            isSKU=#{isSKU},isDel=#{isDel},updateDate=#{updateDate},author=#{author}  where sid=#{sid}")
    void update(ShuXing shuXing);
    @Insert(" insert  into t_shuxing (name,nameCH,typeId,type,isSKU,isDel,createDate,author)\n" +
            "\n" +
            "  value(#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{author})")
    void add(ShuXing shuXing);
}
