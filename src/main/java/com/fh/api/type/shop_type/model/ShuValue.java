package com.fh.api.type.shop_type.model;

import org.springframework.data.relational.core.sql.In;

public class ShuValue {
private  Integer vid;
private   String name;
private  String nameCH;
private  Integer attId;
private Integer isDel;

    public Integer getIsDel() {
        return isDel;
    }
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
    public Integer getVid() {
        return vid;
    }
    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
