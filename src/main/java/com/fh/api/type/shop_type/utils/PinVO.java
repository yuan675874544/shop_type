package com.fh.api.type.shop_type.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/* 接参的bean对象  */
public class PinVO {

    private Long current; //当前页


    private Long size; //每页展示条数

    private  String name;
    private  Integer isdel;

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
