package com.huang.flower.service.impl;

import com.huang.flower.entity.Vip;
import com.huang.flower.mapper.VipMapper;
import com.huang.flower.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public List<Vip> getAllVip() {
        List<Vip> allVip = vipMapper.getAllVip();
        return allVip;
    }

    @Override
    public void deleteVip(String[] array) {
        vipMapper.deleteVip(array);
    }

    @Override
    public void addVip(int id) {
        vipMapper.addVip(id);
    }

    @Override
    public Vip getVipId(int id) {
        Vip vip = vipMapper.getVipId(id);
        if(vip == null || vip.equals("")){
            throw new RuntimeException("还不是会员");
        }
        return vip;
    }
}
