package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.JueSe;
import com.fh.api.type.shop_type.model.Quan;
import com.fh.api.type.shop_type.service.JueService;
import com.fh.api.type.shop_type.utils.JueVO;
import com.fh.api.type.shop_type.utils.QuanVO;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("JueController")
@CrossOrigin
public class JueController {
    @Resource
    private JueService jueService;
    /*查询
     * 路径   127.0.0.1:8080/JueController/list
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
    /*
     * 路径   127.0.0.1:8080/JueController/add
     *
     * 参数 name  isDel createDate  author
     *
     * post请求
     *
     * */
    //新增
    @PostMapping("add")
    public Map add(JueSe jueSe){
        Map map=new HashMap();
        jueService.add(jueSe);
        map.put("code",1);
        return map;
    }
    /*
     * 路径   127.0.0.1:8080/JueController/deleteIsdel
     *
     * 参数 id
     *
     * post请求
     *
     * */
    @PostMapping("deleteIsdel")
    public ResultData deleteIsdel(Integer jid){
        jueService.deleteIsdel(jid);
        return ResultData.success(null);
    }
    /*
     * 路径   127.0.0.1:8080/JueController/getDataByid
     *
     * 参数：jid
     *
     *
     * get请求
     *
     * */
    //根据id查询数据
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer jid){

        return ResultData.success(jueService.getDataByid(jid));
    }
}
