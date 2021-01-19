package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.service.ShuService;
import com.fh.api.type.shop_type.utils.ResultData;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ShuController")
@CrossOrigin
public class ShuController {
    @Resource
    private ShuService shuService;
    /*查询
     * 路径   127.0.0.1:8080/ShuController/queryShuData
     *
     * 参数 current(当前页) size(每页展示条数)
     *
     * post请求
     *
     * */
    @PostMapping("queryShuData")
    public ResultData queryShuData(ShuVO vo){
        if (vo.getCurrent()==null){
            ResultData.error(400,"非法请求");
        }
        if (vo.getSize()==null){
            ResultData.error(400,"非法请求");
        }
        Map map=shuService.queryShuData(vo);
        return  ResultData.success(map);

    }
    //删除
    /*
     * 路径   127.0.0.1:8080/ShuController/deleteIsdel
     *
     * 参数 id
     *
     * post请求
     *
     * */
    @PostMapping("deleteIsdel")
    public     ResultData deleteIsdel(Integer sid){
        shuService.deleteIsdel(sid);
        return ResultData.success(null);
    }
    /*
     * 路径   127.0.0.1:8080/ShuController/getDataByid
     *
     * 参数：sid
     *
     *
     * get请求
     *
     * */
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer sid){
        return ResultData.success(shuService.getDataByid(sid));
    }
    /*
     * 路径   127.0.0.1:8080/ShuController/update
     *
     * 参数：sid name nameCH typeId type  isSKU updateDate
     *
     * post请求
     *
     * */
    @PostMapping("update")
    public ResultData update(ShuXing shuXing){
        shuService.update(shuXing);
        return  ResultData.success(null);
    }
    /*
     * 路径   127.0.0.1:8080/ShuController/add
     *
     * 参数 name nameCH  typeId  type isSKU createDate b
     *
     * post请求
     *
     * */
    @PostMapping("add")
    public  Map add(ShuXing shuXing){
        Map map=new HashMap();
        shuService.add(shuXing);
        map.put("code",1);
        return map;
    }
    @GetMapping("queryDataByTypeId")
    public ResultData queryDataByTypeId(Integer typeId){
        return ResultData.success(shuService.queryDataByTypeId(typeId));
    }
}
