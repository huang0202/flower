package com.huang.flower.service.impl;

import com.huang.flower.entity.Flower;
import com.huang.flower.mapper.FlowerMapper;
import com.huang.flower.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerMapper flowerMapper;


    @Override
    public List<Flower> getAllFlower() {
        List<Flower> allFlower = flowerMapper.getAllFlower();
        return allFlower;
    }

    @Override
    public List<Flower> findFlower(String name) {
        List<Flower> allFlower = flowerMapper.findFlower(name);
        return allFlower;
    }

    @Override
    public void deleteFlower(String[] array) {

    }

    @Override
    public void addFlower(String name, Double price, int stock, String remark, String img, int kind_id) {
        flowerMapper.addFlower(name,price,stock,remark,img,kind_id);
    }

    @Override
    public Flower getFlowerById(int id) {
        Flower flowerById = flowerMapper.getFlowerById(id);
        return  flowerById;
    }

    @Override
    public void editFlower(int id,String name, Double price, int stock, String remark, String img, int kind_id) {
        flowerMapper.editFlower(id,name,price,stock,remark,img,kind_id);
    }

    @Override
    public void addStock(int id, int num) {
        flowerMapper.addStock(id,num);
    }

    @Override
    public List<Flower> getFlowerByKindId(int kind_id) {
        List<Flower> allFlower = flowerMapper.getFlowerByKindId(kind_id);
        return allFlower;
    }

    @Override
    public String[] getFlowerOfStockLessNum(int minimum) {
        String[] allFlowerOfLess = flowerMapper.getFlowerOfStockLessNum(minimum);
        return allFlowerOfLess;
    }

    @Override
    public String[] getIdsByFlowerKey(String flower_name_key) {
        String[] array = flowerMapper.getIdsByFlowerKey(flower_name_key);
        return  array;
    }


}
