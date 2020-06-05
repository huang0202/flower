package com.huang.flower.service;

import com.huang.flower.entity.FlowerOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlowerOrderService {


    /**
     * 查出所有的订单信息
     *
     * @return
     */
    public List<FlowerOrder> getAllFlowerOrder();


    /**
     * 批量删除花蕊订单信息
     *
     * @param array
     */
    public void deleteFlowerOrder(String[] array);


    /**
     * 添加订单信息
     *
     * @param flower_id
     * @param user_id
     * @param price
     * @param order_time
     * @param num
     * @param remark
     */
    public void addFlowerOrder(@Param("flower_id") int flower_id,
                               @Param("user_id") int user_id,
                               @Param("price") Double price,
                               @Param("num") int num,
                               @Param("order_time") Date order_time,
                               @Param("remark") String remark);

    /**
     * 通过 ids查询订单
     * @param array
     * @return
     */
    public List<FlowerOrder> findFlowerOrderByIds(String array[]);

    /**
     * 购买一个花蕊
     * @param flowerOrder
     */
    public void buyOneFlower(FlowerOrder flowerOrder);
}
