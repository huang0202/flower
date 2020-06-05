package com.huang.flower.entity;

public class BouquetFlower {
    private int bouquet_id;
    private int flower_id;
    private String bouquet_name;
    private String flower_name;
    private int flower_num;

    public int getBouquet_id() {
        return bouquet_id;
    }

    public void setBouquet_id(int bouquet_id) {
        this.bouquet_id = bouquet_id;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public int getFlower_num() {
        return flower_num;
    }

    public void setFlower_num(int flower_num) {
        this.flower_num = flower_num;
    }
}
