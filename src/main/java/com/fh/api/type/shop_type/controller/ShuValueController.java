package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.ShuValue;
import com.fh.api.type.shop_type.service.ShuValueService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.*;
import sun.net.idn.Punycode;

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
    /*查询
     * 路径   127.0.0.1:8080/ShuValueController/queryAll
     *
     * 参数 attId
     *
     * get请求
     *
     * */
    @GetMapping("queryAll")
    public ResultData queryAll(Integer attId){
        List<ShuValue> list=shuValueService.queryAll(attId);
        return ResultData.success(list);
    }
    //删除
    /*
     * 路径   127.0.0.1:8080/ShuValueController/deleteIsdel
     *
     * 参数 vid
     *
     * post请求
     *
     * */
    @PostMapping("deleteIsdel")
    public     ResultData deleteIsdel(Integer vid){
        shuValueService.deleteIsdel(vid);
        return ResultData.success(null);
    }
    //新增
    /*
     * 路径   127.0.0.1:8080/ShuValueController/add
     *
     * 参数 name nameCh attId
     *
     * post请求
     *
     * */
    @PostMapping("add")
    public  Map add(ShuValue shuValue){
        Map map=new HashMap();
        shuValueService.add(shuValue);
        map.put("code",1);
        return map;
    }
    //根据id去查询单条数据
    /*
     * 路径   127.0.0.1:8080/ShuValueController/getDataByid
     *
     * 参数：vid
     *
     *
     * get请求
     *
     * */
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer vid){
        return ResultData.success(shuValueService.getDataByid(vid));
    }
    //修改
    /*
     * 路径   127.0.0.1:8080/ShuValueController/update
     *
     * 参数：id name nameCH vid(必传)
     *
     * post请求
     *
     * */
    @PostMapping("update")
    public ResultData update(ShuValue shuValue){
        shuValueService.update(shuValue);
        return ResultData.success(null);
    }
}
