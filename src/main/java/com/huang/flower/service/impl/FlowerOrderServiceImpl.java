package com.huang.flower.service.impl;

import com.huang.flower.entity.FlowerOrder;
import com.huang.flower.mapper.FlowerOrderMapper;
import com.huang.flower.service.FlowerOrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlowerOrderServiceImpl implements FlowerOrderService {

    private static Logger logger = LoggerFactory.getLogger(FlowerOrderServiceImpl.class);

    @Autowired
    private FlowerOrderMapper flowerOrderMapper;

    @Override
    public List<FlowerOrder> getAllFlowerOrder() {
        List<FlowerOrder> allFlowerOrder = flowerOrderMapper.getAllFlowerOrder();
        return  allFlowerOrder;
    }

    @Override
    public void deleteFlowerOrder(String[] array) {
        flowerOrderMapper.deleteFlowerOrder(array);
    }

    @Override
    public void addFlowerOrder(int flower_id, int user_id, Double price, int num, Date order_time, String remark) {
        flowerOrderMapper.addFlowerOrder(flower_id,user_id,price,num,order_time,remark);
    }

    @Override
    public List<FlowerOrder> findFlowerOrderByIds(String[] array) {
        List<FlowerOrder> allFlowerOrder = flowerOrderMapper.findFlowerOrderByIds(array);
        return allFlowerOrder;
    }

    @Override
    public void buyOneFlower(FlowerOrder flowerOrder) {
        try {
            flowerOrderMapper.buyOneFlower(flowerOrder.getFlower_id(), flowerOrder.getUser_id(), flowerOrder.getNum(), flowerOrder.getPrice(), flowerOrder.getOrder_time(), flowerOrder.getRemark());
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }

}
