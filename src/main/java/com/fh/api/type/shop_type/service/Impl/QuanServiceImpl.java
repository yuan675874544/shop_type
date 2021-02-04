package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.QuanDao;
import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.service.QuanService;
import com.fh.api.type.shop_type.utils.QuanVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public void add(Quan quan) {
        quan.setIsDel(0);
        quan.setAuthor("袁亚洲");
        quan.setCreateDate(new Date());
        quanDao.add(quan);
    }

    @Override
    public Map queryQuanDataPage(QuanVO vo) {
        Map map=new HashMap();
        Integer integer=quanDao.queryCount(vo);
        map.put("count",integer);
        List<Quan> quan=quanDao.queryDataByVo(vo);
        map.put("list",quan);
        return map;
    }
}
