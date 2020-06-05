package com.huang.flower.service.impl;

import com.huang.flower.entity.Kind;
import com.huang.flower.mapper.KindMapper;
import com.huang.flower.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindMapper kindMapper;


    @Override
    public List<Kind> getAllKind() {
        List<Kind> allKind = kindMapper.getAllKind();
        return allKind;
    }

    @Override
    public void deleteKind(String[] array) {
        kindMapper.deleteKind(array);
    }

    @Override
    public void addKind(String name) {
        kindMapper.addKind(name);
    }

    @Override
    public void editKind(int id, String name) {
        kindMapper.editKind(id,name);
    }

    @Override
    public List<Kind> findKindByKey(String kind_name_key) {
        List<Kind> allKind = kindMapper.findKindByKey(kind_name_key);
        return allKind;
    }
}
