package com.fh.api.type.shop_type.controller;

import com.fh.api.type.shop_type.service.ShopService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("ShopController")
public class ShopController {
    @Resource
    private ShopService shopService;
}
