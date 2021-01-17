package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.ShuValueDao;
import com.fh.api.type.shop_type.model.ShuValue;
import com.fh.api.type.shop_type.service.ShuValueService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.security.PublicKey;
import java.util.List;

@Service
public class ShuValueServiceImpl implements ShuValueService {
    @Resource
    private ShuValueDao shuValueDao;

    @Override
    public List<ShuValue> queryAll(Integer attId) {
        return shuValueDao.queryAll(attId);
    }

    @Override
    public void delValue(Integer vid) {
        shuValueDao.delValue(vid);
    }
}
