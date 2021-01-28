package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.ShuDao;
import com.fh.api.type.shop_type.dao.ShuValueDao;
import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.ShopDatas;
import com.fh.api.type.shop_type.model.ShuValue;
import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.service.ShuService;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ShuXingService implements ShuService {
    @Resource
    private ShuDao shuDao;
    @Resource
    private ShuValueDao shuValueDao;


    @Override
    public Map queryShuData(ShuVO vo) {
        Map map=new HashMap();
        Integer integer=shuDao.queryCount(vo);
        map.put("count",integer);
        List<ShuXing> pin=shuDao.queryDataByVo(vo);
        map.put("list",pin);
        return map;
    }

    @Override
    public void deleteIsdel(Integer sid) {

        shuDao.deleteIsdel(sid);
    }

    @Override
    public Map getDataByid(Integer sid) {
        return shuDao.getDataByid(sid);
    }

    @Override
    public void update(ShuXing shuXing) {
        shuXing.setUpdateDate(new Date());
        shuDao.update(shuXing);
    }

    @Override
    public void add(ShuXing shuXing) {
        shuXing.setCreateDate(new Date());
        shuXing.setIsDel(0);
        shuDao.add(shuXing);
    }

    @Override
    public List<ShuXing> queryDataByTypeId(Integer typeId) {
        return shuDao.queryDataByTypeId(typeId);
    }

    @Override
    public Map queryDatasType(Integer typeId) {
        //声明返回数据
        Map rs=new HashMap();
        //查询出所有的属性数据
        List<ShuXing>list=shuDao.queryDatasType(typeId);
        //声明skuDatas
        List<ShuXing>skuDats=new ArrayList<>();
        //声明attrDatas
        List<ShuXing>attrDatas=new ArrayList<>();
        //遍历所有的属性数据
        for (int i = 0; i < list.size(); i++) {
            //得到具体的一个属性
            ShuXing shuXing = list.get(i);
            //判断此属性是否为sku
            if (shuXing.getIsSKU()==1){
                //判断此属性的类型   如果是input 没有values
                if (shuXing.getType()!=3){
                    List<ShuValue>shuValue=shuValueDao.queryAllDataByAid(shuXing.getSid());
                    shuXing.setValues(shuValue);
                }
                attrDatas.add(shuXing);
            }else {
                //是sku数据
                //判断此属性的类型   如果是input 没有values
                if (shuXing.getType()!=3){
                    List<ShuValue>shuValue=shuValueDao.queryAllDataByAid(shuXing.getSid());
                    shuXing.setValues(shuValue);
                }
                skuDats.add(shuXing);
            }
        }
        //查询sku数据
        rs.put("skuDatas",skuDats);
        //非sku数据
        rs.put("attrDatas",attrDatas);
        return rs;
    }

}
