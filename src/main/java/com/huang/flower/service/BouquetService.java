package com.huang.flower.service;

import com.huang.flower.entity.Bouquet;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BouquetService {

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
