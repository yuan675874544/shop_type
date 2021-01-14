package com.fh.api.type.shop_type.dao;

import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.utils.PinVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

public interface PinDao {
    Integer queryPinCount(PinVO vo);

    List<Pin> queryPinDataByVo(PinVO vo);
    @Insert(" insert  into t_pin (name,bandE,imgPath,bandDesc,ord,createDate,author,isdel)\n" +
            "\n" +
            "  value(#{name},#{bandE},#{imgPath},#{bandDesc},#{ord},#{createDate},#{author},#{isdel})")
    void add(Pin pin);
    @Select("select * from t_pin  where iid=#{iid}")
    Map getDataByid(Integer id);
    @Update("update  t_pin set  name=#{name},bandE=#{bandE},imgPath=#{imgPath},isdel=#{isdel}, " +
            "            bandDesc=#{bandDesc},updateDate=#{updateDate} where iid=#{iid}")
    void update(Pin pin);
    @Update("update t_pin set isdel=1 where iid=#{iid}")
    void deleteIsdel(Integer iid);
}
