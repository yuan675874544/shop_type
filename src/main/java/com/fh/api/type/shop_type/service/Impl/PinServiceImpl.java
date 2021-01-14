package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.PinDao;
import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.ShopType;
import com.fh.api.type.shop_type.service.PinService;
import com.fh.api.type.shop_type.utils.PinVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PinServiceImpl implements PinService {
    @Resource
    private PinDao pinDao;

    @Override
    public Map queryPinDataPage(PinVO vo) {
        Map map=new HashMap();
        Integer integer=pinDao.queryPinCount(vo);
        map.put("count",integer);
        List<Pin> pin=pinDao.queryPinDataByVo(vo);
        map.put("list",pin);
        return map;
    }

    @Override
    public void add(Pin pin) {
        pin.setCreateDate(new Date());
        pin.setIsdel(0);
        pinDao.add(pin);
    }

    @Override
    public Map getDataByid(Integer id) {
      Map map=  pinDao.getDataByid(id);
        return map;
    }


    @Override
    public void update(Pin pin) {
        pin.setUpdateDate(new Date());
        pinDao.update(pin);
    }

    @Override
    public void deleteIsdel(Integer iid) {
        pinDao.deleteIsdel(iid);
    }

}
