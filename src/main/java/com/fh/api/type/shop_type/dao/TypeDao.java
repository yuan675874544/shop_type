package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.ShopType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.relational.core.sql.Values;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TypeDao {
    @Select("select * from   shop_type  where isDel=0")
    List<ShopType> queryData();
    @Select("select * from shop_type where pid=#{pid}")
    List<ShopType> getDataByPid(Integer pid);
    @Select("select id from shop_type where createDate=#{createDate}")
    Integer queryCreateDate(Date createDate);
    @Insert(" insert  into shop_type (name,pid,createDate)\n" +
            "\n" +
            "  value(#{name},#{pid},#{createDate})")
    void add(ShopType shopType);

    @Select("select * from shop_type where id=#{id}")
    Map getDataByid(Integer id);

    @Update("<script>update shop_type set updateDate=#{updateDate}" +
            " <if test='name != null and name != &quot;&quot;'>  , name  = #{name}</if>" +
            " <if test='pid != null and pid != &quot;&quot;'>  , pid  = #{pid}</if>" +
            " <if test='isDel != null and isDel != &quot;&quot;'>  , isDel  =#{isDel} </if>" +
            " where id=#{id} </script>")
    void update(ShopType shopType);
}


