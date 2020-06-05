package com.huang.flower.controller;

import com.huang.flower.entity.Flower;
import com.huang.flower.entity.Supplier;
import com.huang.flower.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;


    /**
     * 跳转供应商页面
     *
     * @param map
     * @return
     */
    @GetMapping("/admin/supplier/supplier")
    public String toMainSupplier(Map<String, Object> map) {
        List<Supplier> allSupplier = supplierService.getAllSupplier();
        map.put("allSupplier", allSupplier);
        return "admin/supplier/supplier";
    }

    /**
     * 花蕊供应商批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/supplier/delete")
    public Map<String, String> adminFlowerDelect(@PathParam("ids") String ids) {
        String[] array = ids.split(",");
        supplierService.deleteSupplier(array);
        Map<String, String> map = new HashMap();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/supplier/add")
    public Map<String, String> adminFlowerAdd(@PathParam("name") String name,
                                              @PathParam("phone") String phone,
                                              @PathParam("email") String email,
                                              @PathParam("province") String province,
                                              @PathParam("city") String city,
                                              @PathParam("street") String street,
                                              @PathParam("detailed") String detailed,
                                              @PathParam("flower_id") String flower_id) {

        Map<String, String> map = new HashMap();
        supplierService.addSupplier(name,phone,email,province,city,street,detailed,Integer.parseInt(flower_id));
        map.put("status", "200");
        map.put("msg", "添加成功");
        return map;
    }



    /**
     * 通过id查找flower，实现编辑回显
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/supplier/getSupplierById")
    public Map<String, Object> getSupplierById(@PathParam("id") String id) {
        Supplier supplier = supplierService.getSupplierById(Integer.parseInt(id));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("supplier", supplier);
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/supplier/edit")
    public Map<String, String> adminSupplierEdit( @PathParam("id") String id,
                                                @PathParam("name") String name,
                                                @PathParam("phone") String phone,
                                                @PathParam("email") String email,
                                                @PathParam("province") String province,
                                                @PathParam("city") String city,
                                                @PathParam("street") String street,
                                                @PathParam("detailed") String detailed,
                                                @PathParam("flower_id") String flower_id) {

        Map<String, String> map = new HashMap();
        supplierService.editSupplier(Integer.parseInt(id),name,phone,email,province,city,street,detailed,Integer.parseInt(flower_id));
        map.put("status", "200");
        map.put("msg", "编辑成功");
        return map;
    }
    @GetMapping("/admin/supplier/findByKey")
    public String findSupplierByKey(@RequestParam("supplier_name_key") String supplier_name_key,
                                  Map<String, Object> map) {
        List<Supplier> allSupplier = supplierService.findSupplier(supplier_name_key);
        map.put("allSupplier", allSupplier);
        return "admin/supplier/supplier";
    }


}
