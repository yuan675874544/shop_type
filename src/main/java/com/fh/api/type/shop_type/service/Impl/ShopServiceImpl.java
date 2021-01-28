package com.fh.api.type.shop_type.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.api.type.shop_type.dao.ShopAttrDao;
import com.fh.api.type.shop_type.dao.ShopDao;
import com.fh.api.type.shop_type.model.Shop;
import com.fh.api.type.shop_type.model.ShopDatas;
import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.service.ShopService;
import com.fh.api.type.shop_type.utils.ShopDataVo;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.*;

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
        shop.setIsDel(0);
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

    @Override
    public Map queryShopData(ShopDataVo vo) {
        Map map=new HashMap();
        Integer integer=shopDao.queryCount(vo);
        map.put("count",integer);
        List<Shop> shop=shopDao.queryDataByVo(vo);
        map.put("list",shop);
        return map;
    }

    @Override
    public List<ShopDatas> queryAttrByPid(Integer pid) {
        return shopAttrDao.queryAttrByPid(pid);
    }

    @Override
    public Map querySKUckvalues(Integer pid) {
        Map data=new HashMap();
        // 查选
        List<ShopDatas> shopDatas = shopAttrDao.queryDataByProId(pid);
        //sku的数据  {"memsize":["32g"],"color":['红色','绿色'],"netType":'联通'}
        Map skuData=new HashMap();
        Map attrData=new HashMap();
        Map tableData=new HashMap();
        List <JSONObject> tableList=new ArrayList<>();
        //遍历所有数据
        for (int i = 0; i <shopDatas.size() ; i++) {
            //得到具体的一个属性数据
            ShopDatas attrDatas = shopDatas.get(i);
            //判断此属性为那种属性
            if(attrDatas.getPrice()!=null){ //是sku属性   这种判断不严谨
                //得到对应数据的json字符串 {"memsize":"32G","pricess":111,"color":"红色","netType":"联通","storcks":111}
                //得到对应数据的json字符串 {"memsize":"32G","pricess":111,"color":"红色","netType":"联通","storcks":111}
                //将字符串转为json对象  引入fastjson工具类
                JSONObject jsonObject = JSONObject.parseObject(attrDatas.getAttrData());
                //遍历jsonobject
                Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    String key=entry.getKey();//color
                    //判断skuData中是否有此属性
                    Set values = (Set) skuData.get(key);
                    if(values!=null){
                        values.add(entry.getValue());
                    }else{
                        //创建一个set 集合
                        Set valuesSet =new HashSet();
                        valuesSet.add(entry.getValue());
                        skuData.put(key,valuesSet);
                    }
                }
                //表格属性放入list
                tableList.add(jsonObject);

            }else {
                //得到对应数据的json字符串  {"factory":"苹果尝试"}
                JSONObject obj=JSONObject.parseObject(attrDatas.getAttrData());
                Set<Map.Entry<String, Object>> entries = obj.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    attrData.put(entry.getKey(),entry.getValue());
                }
            }


        }
        //将sku 和attr 放入返回值中
        data.put("skudata",skuData);
        data.put("attrdata",attrData);
        data.put("tableData",tableList);
        return data;
    }


}
