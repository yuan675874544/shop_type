package com.fh.api.type.shop_type.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.api.type.shop_type.dao.ShopAttrDao;
import com.fh.api.type.shop_type.dao.ShopDao;
import com.fh.api.type.shop_type.model.Shop;
import com.fh.api.type.shop_type.model.ShopDatas;
import com.fh.api.type.shop_type.service.ShopService;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;

    @Resource
    private  ShopAttrDao shopAttrDao;

    @Override
    @Transactional //配置事务
    public void add(Shop shop, String attr, String sku) {
        shop.setCreateDate(new Date());
        //返回主键
        shopDao.add(shop);
        // 声明属性数据的对象
        List<ShopDatas>adlist=new ArrayList<>();
        //批量新增
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i < objects.size(); i++) {
            //构建属性数据对象
            ShopDatas datas=new ShopDatas();
            //设置对应的商品id；
            datas.setProId(shop.getShopId());
            datas.setAttrData(objects.get(i).toString());
            //放入集合
            adlist.add(datas);
        }
        //将sku的json数组字符串 转为json数组对象
        JSONArray skuOb = JSONObject.parseArray(sku);
        for (int i = 0; i <skuOb.size() ; i++) {
            //得到一个json对象
            JSONObject dataJs= (JSONObject) skuOb.get(i);
            //构建属性数据对象
            ShopDatas datas=new ShopDatas();
            //设置对应的商品id
            datas.setProId(shop.getShopId());
            datas.setPrice(dataJs.getDouble("pricess"));
            datas.setStorcks(dataJs.getInteger("storcks"));
            dataJs.remove("price");
            dataJs.remove("storck");
            datas.setAttrData(skuOb.get(i).toString());
            //放入集合
            adlist.add(datas);
        }
            shopAttrDao.adds(adlist);

    }

    @Override
    public void deleteIsdel(Integer shopId) {
        shopDao.deleteIsdel(shopId);
    }

    @Override
    public Map getDataByid(Integer shopId) {
        return shopDao.getDataByid(shopId);
    }

    @Override
    public void update(Shop shop) {
        shop.setUpdateDate(new Date());
         shopDao.update(shop);
    }
}
