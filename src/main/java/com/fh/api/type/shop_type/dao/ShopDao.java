package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface ShopDao {
    @Insert("insert into shop (name,title,bandId,productdecs,price,stocks,sortNum,typeId,imgPath,createDate,author,isDel) " +
            "values (#{name},#{title},#{bandId},#{productdecs},#{price},#{stocks},#{sortNum},#{typeId},#{imgPath},#{createDate},#{author},#{isDel})")
    void add(Shop shop);
    @Update("update shop set isDel=1 where shopId=#{shopId} ")
    void deleteIsdel(Integer shopId);
    @Select("select * from shop where shopId=#{shopId}")
    Map getDataByid(Integer shopId);
    @Update("update shop set name=#{name},title=#{title},bandId=#{bandId},productdecs=#{productdecs},price=#{price},stocks=#{stocks},sortNum=#{sortNum},typeId=#{typeId},imgPath=#{imgPath},updateDate=#{updateDate}")
    void update(Shop shop);
}
