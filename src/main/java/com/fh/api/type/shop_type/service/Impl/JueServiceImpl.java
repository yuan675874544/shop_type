package com.fh.api.type.shop_type.service.Impl;

import com.fh.api.type.shop_type.dao.JueDao;
import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.service.JueService;
import com.fh.api.type.shop_type.utils.JueVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JueServiceImpl implements JueService {
    @Resource
    private JueDao jueDao;

    @Override
    public Map queryJueDataPage(JueVO vo) {
        Map map=new HashMap();
        Integer integer=jueDao.queryCount(vo);
        map.put("count",integer);
        List<JueSe> jueSe=jueDao.queryDataByVo(vo);
        map.put("list",jueSe);
        return map;
    }

    @Override
    public void add(JueSe jueSe) {
        jueSe.setCreateDate(new Date());
        jueSe.setIsDel(0);
        jueSe.setAuthor("袁亚洲");
        jueDao.add(jueSe);
    }

    @Override
    public void deleteIsdel(Integer jid) {
        jueDao.deleteIsdel(jid);
    }
}
