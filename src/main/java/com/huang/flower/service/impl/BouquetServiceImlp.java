package com.huang.flower.service.impl;

import com.huang.flower.entity.Bouquet;
import com.huang.flower.mapper.BouquetFlowerMapper;
import com.huang.flower.mapper.BouquetMapper;
import com.huang.flower.service.BouquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BouquetServiceImlp implements BouquetService {

    @Autowired
    private BouquetMapper bouquetMapper;
    @Autowired
    private BouquetFlowerMapper bouquetFlowerMapper;
    @Override
    public  List<Bouquet> getAllBouquet() {
        List<Bouquet> allBouquet = null;
        try{
            allBouquet = bouquetMapper.getAllBouquet();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return allBouquet;
    }

    @Override
    public void deleteBouquet(String[] array) {
        try {
            bouquetFlowerMapper.deleteBouquetFlower(array);
            bouquetMapper.deleteBouquet(array);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
