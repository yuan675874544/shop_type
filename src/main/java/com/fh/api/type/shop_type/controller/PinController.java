package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.dao.PinDao;
import com.fh.api.type.shop_type.model.Pin;
import com.fh.api.type.shop_type.service.PinService;
import com.fh.api.type.shop_type.utils.FileSaveUtils;
import com.fh.api.type.shop_type.utils.PinVO;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("PinController")
public class PinController {
    @Resource
    private PinService pinService;
    //上传文件
    /*
     * 路径   127.0.0.1:8080/PinController/uploadFile
     *
     * 参数 img
     *
     * post请求
     *
     * */
    @PostMapping("uploadFile")
    public ResultData uploadFile(MultipartFile img , HttpServletRequest request){
        String abc = FileSaveUtils.saveFile(img ,"images",request);
        return ResultData.success(abc);
    }
    //查询 分页
    @PostMapping("list")
    public  ResultData list(PinVO vo){
        if (vo.getCurrent()==null){
            return  ResultData.error(400,"非法请求");
        }if (vo.getSize()==null){
            return ResultData.error(400,"非法请求");
        }
        Map map=pinService.queryPinDataPage(vo);
        return ResultData.success(map);
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
    //新增
    @PostMapping("add")
    public  Map add(Pin pin){
        Map map=new HashMap();
        pinService.add(pin);
        map.put("code",1);
        return map;
    }
    /*
     * 路径   127.0.0.1:8080/PinController/getDataByid
     *
     * 参数：id
     *
     *
     * get请求
     *
     * */
    //根据id查询数据
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer pid){
        return ResultData.success(pinService.getDataByid(pid));
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
    public ResultData update(Pin pin){
        pinService.update(pin);
        return ResultData.success(null);
    }
    //删除
    @PostMapping("deleteIsdel")
    public     ResultData deleteIsdel(Integer iid){
        pinService.deleteIsdel(iid);
        return ResultData.success(null);
    }
}
