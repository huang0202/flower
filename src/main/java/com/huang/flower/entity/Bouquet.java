package com.huang.flower.entity;

public class Bouquet {
    private int bouquet_id;
    private String bouquet_name;
    private double price;
    private String remark;
    private String img;
    private int kind_id;
    //连接查询出来
    //只有get方法
    private String kind_name;

    public Bouquet(String bouquet_name, double price, String remark, String img,int kind_id) {
        this.bouquet_name = bouquet_name;
        this.price = price;
        this.remark = remark;
        this.img = img;
        this.kind_id = kind_id;
    }

    public Bouquet() {
    }

    public int getBouquet_id() {
        return bouquet_id;
    }

    public void setBouquet_id(int bouquet_id) {
        this.bouquet_id = bouquet_id;
    }

    public String getBouquet_name() {
        return bouquet_name;
    }

    public void setBouquet_name(String bouquet_name) {
        this.bouquet_name = bouquet_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public String getKind_name() {
        return kind_name;
    }
}
