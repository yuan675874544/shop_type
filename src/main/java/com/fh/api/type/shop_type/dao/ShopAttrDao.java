package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShopDatas;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopAttrDao {

    @Insert("<script>insert into shop_datas (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  </foreach> </script>")
    void adds(List<ShopDatas> adlist);
    @Select("select * from shop_datas where proId=#{pid}")
    List<ShopDatas> queryAttrByPid(Integer pid);
    @Select("select * from shop_datas where proId=#{pid}")
    List<ShopDatas> queryDataByProId(Integer pid);
}
