package com.huang.flower.mapper;


import com.huang.flower.entity.BouquetFlower;

import java.util.List;

public interface BouquetFlowerMapper {


    /**
     * 查询所有的花束组合信息
     * @return
     */
    public List<BouquetFlower> getAllBouquetFlower();


    /**
     * 删除花束组成信息
     *
     * @param array
     */
    public void deleteBouquetFlower(String[] array);
}
