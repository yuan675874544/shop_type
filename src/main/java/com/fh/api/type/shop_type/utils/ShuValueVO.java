package com.fh.api.type.shop_type.utils;

import org.springframework.data.relational.core.sql.In;

/* 接参的bean对象  */
public class ShuValueVO {

    private Long current; //当前页


    private Long size; //每页展示条数

    private  String name;

    private  String nameCH;

    private Integer attId;

    public String getNameCH() {
        return nameCH;
    }

    public void setNameCH(String nameCH) {
        this.nameCH = nameCH;
    }

    public Integer getAttId() {
        return attId;
    }

    public void setAttId(Integer attId) {
        this.attId = attId;
    }

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
