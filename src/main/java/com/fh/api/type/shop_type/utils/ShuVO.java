package com.fh.api.type.shop_type.utils;

/* 接参的bean对象  */
public class ShuVO {

    private Long current; //当前页


    private Long size; //每页展示条数

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
