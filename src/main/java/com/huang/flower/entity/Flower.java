package com.huang.flower.entity;

public class Flower {
    private int id;
    private String name;   //名称
    private double price;   // 单价
    private int stock;     //库存
    private String remark; //描述
    private String img;    //图片路径
    private int kind_id;

    public Flower(int id, String name, double price, int stock, String remark, String img, int kind_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.remark = remark;
        this.img = img;
        this.kind_id = kind_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
}
