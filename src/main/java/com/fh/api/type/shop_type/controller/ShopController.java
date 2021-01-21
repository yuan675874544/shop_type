package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.Shop;
import com.fh.api.type.shop_type.service.ShopService;
import com.fh.api.type.shop_type.utils.OssFileUtils;
import com.fh.api.type.shop_type.utils.ResultData;
import com.fh.api.type.shop_type.utils.ShopDataVo;
import com.fh.api.type.shop_type.utils.ShuVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("ShopController")
@CrossOrigin
public class ShopController {
    @Resource
    private ShopService shopService;
    /*
     * 路径   127.0.0.1:8080/ShopController/add
     *
     * 参数 shopId name title bandId productdecs price stocks sortNum  typeId   imgPath  createDate    author   isDel
     *
     * post请求
     *
     * */
    @PostMapping("add")
    public ResultData add(Shop shop,String attr,String sku){
     shopService.add(shop,attr,sku);
     return ResultData.success("");
    }
    //上传文件
    /*
     * 路径   127.0.0.1:8080/ShopController/uploadFile
     *
     * 参数 img
     *
     * post请求
     *
     * */
    @RequestMapping("uploadFile")
    public ResultData uploadFile(MultipartFile img) throws IOException {
        //处理新名称
        String originalFilename = img.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFileUtils.uploadFile(img.getInputStream(),newName));
    }
    /*
     * 路径   127.0.0.1:8080/ShopController/deleteIsdel
     *
     * 参数 shopId
     *
     * post请求
     *
     * */
    @PostMapping("deleteIsdel")
    public     ResultData deleteIsdel(Integer shopId){
        shopService.deleteIsdel(shopId);
        return ResultData.success(null);
    }
    /*
     * 路径   127.0.0.1:8080/ShopController/getDataByid
     *
     * 参数：shopId
     *
     *
     * get请求
     *
     * */
    //根据id查询数据
    @GetMapping("getDataByid")
    public  ResultData getDataByid(Integer shopId){
        return ResultData.success(shopService.getDataByid(shopId));
    }
    /*
     * 路径   127.0.0.1:8080/ShopController/update
     *
     * 参数：shopId name title bandId productdecs price stocks sortNum  typeId   imgPath  updateDate    author   isDel
     *
     * post请求
     *
     * */
    @PostMapping("update")
    public  ResultData update(Shop shop){
        shopService.update(shop);
        return  ResultData.success(null);
    }
    /*查询
     * 路径   127.0.0.1:8080/ShuController/queryShuData
     *
     * 参数 current(当前页) size(每页展示条数)
     *
     * post请求
     *
     * */
    @PostMapping("queryShopData")
    public ResultData queryShuData(ShopDataVo vo){
        if (vo.getCurrent()==null){
            ResultData.error(400,"非法请求");
        }
        if (vo.getSize()==null){
            ResultData.error(400,"非法请求");
        }
        Map map=shopService.queryShopData(vo);
        return  ResultData.success(map);

    }

}
