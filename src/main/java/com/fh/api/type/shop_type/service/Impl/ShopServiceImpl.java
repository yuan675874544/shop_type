package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.ShopDao;
import com.fh.api.type.shop_type.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;
}
