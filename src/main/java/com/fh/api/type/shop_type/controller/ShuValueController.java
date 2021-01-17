package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.ShuValue;
import com.fh.api.type.shop_type.service.ShuValueService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("ShuValueController")
@RestController
@CrossOrigin
public class ShuValueController {
    @Resource
    private ShuValueService shuValueService;
    //查询
    @GetMapping("queryAll")
    public ResultData queryAll(Integer attId){
        List<ShuValue> list=shuValueService.queryAll(attId);
        return ResultData.success(list);
    }
    //删除
    //删除
    @DeleteMapping("delValue")
    public Map delValue(Integer vid){
        Map map=new HashMap();
        shuValueService.delValue(vid);
        map.put("code",1);
        return  map;
    }
}