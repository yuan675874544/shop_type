package com.fh.api.type.shop_type.service;

import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.utils.JueVO;

import java.util.Map;

public interface JueService {
    Map queryJueDataPage(JueVO vo);

    void add(JueSe jueSe);

    void deleteIsdel(Integer jid);

    Map getDataByid(Integer jid);
}
