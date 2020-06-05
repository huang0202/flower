package com.huang.flower.service.impl;

import com.huang.flower.entity.Supplier;
import com.huang.flower.mapper.SupplierMapper;
import com.huang.flower.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    public List<Supplier> getAllSupplier() {
        List<Supplier> allSupplier = supplierMapper.getAllSupplier();
        return allSupplier;
    }

    @Override
    public void deleteSupplier(String[] array) {
        supplierMapper.deleteSupplier(array);
    }

    @Override
    public void addSupplier(String name, String phone, String email, String province, String city, String street, String detailed, int flower_id) {
        supplierMapper.addSupplier(name,phone,email,province,city,street,detailed,flower_id);
}

    @Override
    public Supplier getSupplierById(int id) {
        Supplier supplier = supplierMapper.getSupplierById(id);
        return  supplier;
    }

    @Override
    public void editSupplier(int id, String name, String phone, String email, String province, String city, String street, String detailed, int flower_id) {
        supplierMapper.editSupplier(id,name,phone,email,province,city,street,detailed,flower_id);
    }

    @Override
    public List<Supplier> findSupplier(String suppler_name_key) {
        List<Supplier> allSupplier = supplierMapper.findSupplier(suppler_name_key);
        return allSupplier;
    }
}
