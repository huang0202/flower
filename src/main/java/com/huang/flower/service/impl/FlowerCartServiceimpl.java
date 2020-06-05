package com.huang.flower.service.impl;


import com.huang.flower.entity.FlowerCartJoinFlower;
import com.huang.flower.mapper.FlowerCartMapper;
import com.huang.flower.service.FlowerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlowerCartServiceimpl implements FlowerCartService {
    @Autowired
    private FlowerCartMapper flowerCartMapper;

    @Override
    public void jionFlowerCart(long user_id, long flower_id, long num) {
        Date join_time = new Date();
        flowerCartMapper.jionFlowerCart(user_id, flower_id, num, join_time);
    }

    @Override
    public List<FlowerCartJoinFlower> getAllFlowerCartByUserId(int user_id) {
        List<FlowerCartJoinFlower> allFlowerOfCart = flowerCartMapper.getAllFlowerCartByUserId(user_id);
        return allFlowerOfCart;
    }

    @Override
    public void flowerOfCartDelete(long user_id, long flower_id) {
        flowerCartMapper.flowerOfCartDelete(user_id,flower_id);
    }


}
