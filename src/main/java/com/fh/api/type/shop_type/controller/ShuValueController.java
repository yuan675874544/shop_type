package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.ShuValue;
import com.fh.api.type.shop_type.service.ShuValueService;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("ShuValueController")
@RestController
@CrossOrigin
public class ShuValueController {
    @Resource
    private ShuValueService shuValueService;
    @GetMapping("queryAll")
    public ResultData queryAll(Integer attId){
        List<ShuValue> list=shuValueService.queryAll(attId);
        return ResultData.success(list);
    }
}
