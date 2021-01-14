package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.TypeDao;
import com.fh.api.type.shop_type.model.ShopType;
import com.fh.api.type.shop_type.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;



    @Override
    public Map getDataByPid(Integer pid) {
        Map map=new HashMap();
        List<ShopType>list=typeDao.getDataByPid(pid);
        map.put("data",list);
        return map;
    }

    @Override
    public Integer add(ShopType shopType) {
        shopType.setCreateDate(new Date());
        shopType.setIsDel(0);
        typeDao.add(shopType);
        Integer id = typeDao.queryCreateDate(shopType.getCreateDate());
        return id;
    }


    @Override
    public Map getDataByid(Integer id) {
        return typeDao.getDataByid(id);
    }

    @Override
    public void update(ShopType shopType) {

        typeDao.update(shopType);
    }

    @Override
    public Map queryData() {
        Map map=new HashMap();
        List<ShopType> list=typeDao.queryData();
        map.put("data",list);
        return map;
    }


}
