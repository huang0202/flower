package com.huang.flower.service;

import com.huang.flower.entity.FlowerCart;
import com.huang.flower.entity.FlowerCartJoinFlower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlowerCartService {


    /**
     * 将花蕊加入购物车
     *
     * @param user_id
     * @param flower_id
     * @param num
     */
    public void jionFlowerCart(@Param("user_id") long user_id,
                               @Param("flower_id") long flower_id,
                               @Param("num") long num);

    /**
     * 通过用户的 id查询他的购物车
     *
     * @param user_id
     * @return
     */
    public List<FlowerCartJoinFlower>  getAllFlowerCartByUserId (int user_id);

    /**
     * 删除用户购物车中某个花蕊
     *
     * @param user_id
     * @param flower_id
     */
    public void flowerOfCartDelete(@Param("user_id") long user_id,
                                   @Param("flower_id") long flower_id);
}
