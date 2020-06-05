package com.huang.flower.service;

import com.huang.flower.entity.StockPurchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface StockPurchaseService {

    /**
     * 查询所有的供应记录
     *
     * @return
     */
    public List<StockPurchase> getAllStockPurchase();


    /**
     * 批量stockPurchase信息
     *
     * @param array
     */
    public void deleteStockPurchase(String[] array);


    /**
     * 添加供应记录
     *
     * @param flower_id
     * @param supplier_id
     * @param num
     * @param price
     * @param purchaseTime
     * @param remark
     * @param state
     */
    public void addStockPurchase(int flower_id,
                                 int supplier_id,
                                 int num,
                                 double price,
                                 Date purchaseTime,
                                 String remark,
                                 int state);

    /**
     * 通过id查找stockPurchase记录
     *
     * @param id
     * @return
     */
    public StockPurchase getStockPurchaseById(int id);


    /**
     * 编辑供应记录信息
     *
     * @param id
     * @param flower_id
     * @param supplier_id
     * @param num
     * @param price
     * @param remark
     * @param state
     */
    public void editStockPurchase(@Param("id") int id,
                                  @Param("flower_id") int flower_id,
                                  @Param("supplier_id") int supplier_id,
                                  @Param("num") int num,
                                  @Param("price") double price,
                                  @Param("remark") String remark,
                                  @Param("state") int state);

    /**
     * 通过 ids查询供应记录
     * @param array
     * @return
     */
    public List<StockPurchase> findStockPurchaseByFlowerIds(String array[]);
}
