package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.Shop;
import com.fh.api.type.shop_type.model.ShopDatas;
import com.fh.api.type.shop_type.utils.ShopDataVo;

import java.util.List;
import java.util.Map;

public interface ShopService {

    void add(Shop shop, String attr, String sku);

    void deleteIsdel(Integer shopId);

    Map getDataByid(Integer shopId);

    void  update(Shop shop);

    Map queryShopData(ShopDataVo vo);

    List<ShopDatas> queryAttrByPid(Integer pid);

    Map querySKUckvalues(Integer pid);
}
