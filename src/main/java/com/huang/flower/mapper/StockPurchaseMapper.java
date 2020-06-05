package com.huang.flower.mapper;

import com.huang.flower.entity.FlowerOrder;
import com.huang.flower.entity.StockPurchase;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StockPurchaseMapper {

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
    public void addStockPurchase(@Param("flower_id") int flower_id,
                                 @Param("supplier_id") int supplier_id,
                                 @Param("num") int num,
                                 @Param("price") double price,
                                 @Param("purchaseTime") Date purchaseTime,
                                 @Param("remark") String remark,
                                 @Param("state") int state);


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
