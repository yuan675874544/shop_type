package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.model.Shop;
import com.fh.api.type.shop_type.service.ShopService;
import com.fh.api.type.shop_type.utils.OssFileUtils;
import com.fh.api.type.shop_type.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("ShopController")
public class ShopController {
    @Resource
    private ShopService shopService;
    /*
     * 路径   127.0.0.1:8080/ShopController/add
     *
     * 参数 shopId name title bandId productdecs price stocks sortNum  typeId   imgPath  createDate   updateDate  author   isDel
     *
     * post请求
     *
     * */
    @PostMapping("add")
    public Map add(Shop shop){
        Map map=new HashMap();
        shopService.add(shop);
        map.put("code",200);
        return  map;
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
}
