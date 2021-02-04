package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.service.QuanService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
     * 参数：id name updateDate bandE imgPath bandDesc ord  author
     *
     * post请求
     *
     * */
    @PostMapping("update")
    public ResultData update(Quan quan){
        quanServicel.update(quan);
        return ResultData.success(null);
    }
}
