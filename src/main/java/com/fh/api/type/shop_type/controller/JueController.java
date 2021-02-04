package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.service.JueService;
import com.fh.api.type.shop_type.utils.JueVO;
import com.fh.api.type.shop_type.utils.QuanVO;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("JueController")
@CrossOrigin
public class JueController {
    @Resource
    private JueService jueService;
    /*查询
     * 路径   127.0.0.1:8080/QuanController/list
     *
     * 参数 current(当前页) size(每页展示条数)
     *
     * post请求
     *
     * */
    @PostMapping("list")
    public ResultData list(JueVO vo){
        if (vo.getCurrent()==null){
            return  ResultData.error(400,"非法请求");
        }if (vo.getSize()==null){
            return ResultData.error(400,"非法请求");
        }
        Map map=jueService.queryJueDataPage(vo);
        return ResultData.success(map);
    }
}
