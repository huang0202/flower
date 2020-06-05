package com.huang.flower.mapper;

import com.huang.flower.entity.FlowerOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FlowerOrderMapper {

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
     *添加一个花蕊订单信息
     * @param flower_id
     * @param user_id
     * @param num
     * @param price
     * @param order_time
     * @param remark
     */
    public void  buyOneFlower(@Param("flower_id") int flower_id,
                              @Param("user_id") int user_id,
                              @Param("num") int num,
                              @Param("price") double price,
                              @Param("order_time") Date order_time,
                              @Param("remark") String remark);

    public List<FlowerOrder> test();
}

