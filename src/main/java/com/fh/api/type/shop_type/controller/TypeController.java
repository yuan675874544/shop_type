package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.ShopType;
import com.fh.api.type.shop_type.service.TypeService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("TypeController")
public class TypeController {
    @Resource
    private TypeService typeService;
    /*
    * 路径   127.0.0.1:8080/TypeController/getData
    *
    * 参数：id,pid,name,createDate,updateDate,isDel
    *
    * get请求
    *
    * */
    @GetMapping("getData")
   public ResultData  getData(){
        Map map=typeService.queryData();
        return ResultData.success(map);
    }
    /*
     * 路径   127.0.0.1:8080/TypeController/getDataByPid
     *
     * 参数：pid
     *
     * get请求
     *
     * */
    @GetMapping("getDataByPid")
    public  ResultData getDataByPid(Integer pid){

        return ResultData.success(typeService.getDataByPid(pid));

    }
    /*
     * 路径   127.0.0.1:8080/TypeController/add
     *
     * 参数：pid    name
     *
     * post请求
     *
     * */
    @PostMapping("add")
    public ResultData add(ShopType shopType){
       Integer in =typeService.add(shopType);
        return  ResultData.success(in);
    }
    /*
     * 路径   127.0.0.1:8080/TypeController/getDataByid
     *
     * 参数：id
     *
     *
     * get请求
     *
     * */
//根据id查询数据
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer id){
        return ResultData.success(typeService.getDataByid(id));
    }
    /*
     * 路径   127.0.0.1:8080/TypeController/update
     *
     * 参数：id （必传）     pid   name
     *
     * post请求
     *
     * */
    @PostMapping("update")
    public ResultData update(ShopType shopType){
        typeService.update(shopType);
        return ResultData.success(null);
    }
}
