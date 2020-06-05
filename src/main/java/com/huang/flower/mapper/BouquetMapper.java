package com.huang.flower.mapper;

import com.huang.flower.entity.Bouquet;

import java.util.List;

public interface BouquetMapper {

    /**
     * 查询所有的花束信息
     * @return
     */
    public List<Bouquet> getAllBouquet();

    /**
     * 批量删除花束信息
     *
     * @param array
     */
    public void deleteBouquet(String[] array);
}
