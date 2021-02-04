package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.service.QuanService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("QuanController")
@CrossOrigin
public class QuanController {
    @Resource
    private QuanService quanServicel;
    /*
     * 路径   127.0.0.1:8080/QuanController/deleteIsdel
     *
     * 参数 id
     *
     * post请求
     *
     * */
    @PostMapping("deleteIsdel")
    public ResultData deleteIsdel(Integer qid){
        quanServicel.deleteIsdel(qid);
        return ResultData.success(null);
    }
    /*
     * 路径   127.0.0.1:8080/PinController/update
     *
     * 参数：id name url type isDel CreateDate author
     *
     * post请求
     *
     * */
    @PostMapping("update")
    public ResultData update(Quan quan){
        quanServicel.update(quan);
        return ResultData.success(null);
    }
    /*
     * 路径   127.0.0.1:8080/QuanController/getDataByid
     *
     * 参数：qid
     *
     *
     * get请求
     *
     * */
    //根据id查询数据
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer qid){

        return ResultData.success(quanServicel.getDataByid(qid));
    }
    /*
     * 路径   127.0.0.1:8080/PinController/add
     *
     * 参数 name createDate bandE imgPath bandDesc ord  author
     *
     * post请求
     *
     * */
    //新增
    @PostMapping("add")
    public Map add(Quan quan){
        Map map=new HashMap();
        quanServicel.add(quan);
        map.put("code",1);
        return map;
    }
}
