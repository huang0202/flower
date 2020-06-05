package com.huang.flower.entity;

import java.util.Date;

public class FlowerOrder {
    private int id;
    private int flower_id;
    private int user_id;
    private int num;
    private Double price;
    private Date order_time;
    private String remark;
    private int state;

    public FlowerOrder(int flower_id, int user_id, int num, Double price, Date order_time, String remark) {
        this.flower_id = flower_id;
        this.user_id = user_id;
        this.num = num;
        this.price = price;
        this.order_time = order_time;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
