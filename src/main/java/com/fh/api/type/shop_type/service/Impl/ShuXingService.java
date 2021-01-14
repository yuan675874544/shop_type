package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.ShuDao;
import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.service.ShuService;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShuXingService implements ShuService {
    @Resource
    private ShuDao shuDao;



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

}
