package com.huang.flower.mapper;

import com.huang.flower.entity.FlowerCartJoinFlower;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FlowerCartMapper {

    /**
     * 通过用户的 id查询他的购物车
     *
     * @param user_id
     * @return
     */
    public List<FlowerCartJoinFlower>  getAllFlowerCartByUserId (int user_id);


    /**
     * 将花蕊加入购物车
     *
     * @param user_id
     * @param flower_id
     * @param num
     * @param join_time
     */
    public void jionFlowerCart(@Param("user_id") long user_id,
                               @Param("flower_id") long flower_id,
                               @Param("num") long num,
                               @Param("join_time")Date join_time);

    /**
     * 删除用户购物车中某个花蕊
     *
     * @param user_id
     * @param flower_id
     */
    public void flowerOfCartDelete(@Param("user_id") long user_id,
                                   @Param("flower_id") long flower_id);


}
