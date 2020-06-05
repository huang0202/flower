package com.huang.flower.service.impl;

import com.huang.flower.entity.StockPurchase;
import com.huang.flower.mapper.StockPurchaseMapper;
import com.huang.flower.service.StockPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockPurchaseServiceImpl implements StockPurchaseService {

    @Autowired
    private StockPurchaseMapper stockPurchaseMapper;

    @Override
    public List<StockPurchase> getAllStockPurchase() {
        List<StockPurchase> allStockPurchase = stockPurchaseMapper.getAllStockPurchase();
        return allStockPurchase;
    }

    @Override
    public void deleteStockPurchase(String[] array) {
        stockPurchaseMapper.deleteStockPurchase(array);
    }

    @Override
    public void addStockPurchase(int flower_id, int supplier_id, int num, double price, Date purchaseTime, String remark, int state) {
        stockPurchaseMapper.addStockPurchase(flower_id, supplier_id, num, price, purchaseTime, remark, state);
    }

    @Override
    public StockPurchase getStockPurchaseById(int id) {
        StockPurchase stockPurchase = stockPurchaseMapper.getStockPurchaseById(id);
        return stockPurchase;
    }

    @Override
    public void editStockPurchase(int id, int flower_id, int supplier_id, int num, double price, String remark, int state) {
        stockPurchaseMapper.editStockPurchase(id, flower_id, supplier_id, num, price, remark, state);
    }

    @Override
    public List<StockPurchase> findStockPurchaseByFlowerIds(String[] array) {
        List<StockPurchase> allStockPurchase = stockPurchaseMapper.findStockPurchaseByFlowerIds(array);
        return allStockPurchase;
    }
}
