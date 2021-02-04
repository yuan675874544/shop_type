package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.QuanDao;
import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.service.QuanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class QuanServiceImpl implements QuanService {
    @Resource
    private QuanDao quanDao;

    @Override
    public void deleteIsdel(Integer qid) {
        quanDao.deleteIsdel(qid);
    }

    @Override
    public void update(Quan quan) {
        quanDao.update(quan);
    }

    @Override
    public Map getDataByid(Integer qid) {
        return quanDao.getDataByid(qid);
    }
}
