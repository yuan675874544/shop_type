package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.ShuXing;
import com.fh.api.type.shop_type.service.ShuService;
import com.fh.api.type.shop_type.utils.ResultData;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("ShuController")
@CrossOrigin
public class ShuController {
    @Resource
    private ShuService shuService;
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
    @PostMapping("deleteIsdel")
    public     ResultData deleteIsdel(Integer sid){
        shuService.deleteIsdel(sid);
        return ResultData.success(null);
    }
    //根据id查询
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer sid){
        return ResultData.success(shuService.getDataByid(sid));
    }
    //修改
    @PostMapping("update")
    public ResultData update(ShuXing shuXing){
        shuService.update(shuXing);
        return  ResultData.success(null);
    }
}
