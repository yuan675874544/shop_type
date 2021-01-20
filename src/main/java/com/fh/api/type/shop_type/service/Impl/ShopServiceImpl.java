package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.ShopDao;
import com.fh.api.type.shop_type.model.Shop;
import com.fh.api.type.shop_type.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;

    @Override
    public void add(Shop shop) {
        shop.setIsDel(0);
        shop.setCreateDate(new Date());
        shopDao.add(shop);
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
