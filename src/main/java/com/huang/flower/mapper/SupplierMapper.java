package com.huang.flower.mapper;

import com.huang.flower.entity.Flower;
import com.huang.flower.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {

    /**
     * 查出所有的供货商
     *
     * @return
     */
    public List<Supplier> getAllSupplier();

    /**
     * 批量删除花蕊供应商信息
     *
     * @param array
     */
    public void deleteSupplier(String[] array);

    /**
     * @param name
     * @param phone
     * @param email
     * @param province
     * @param city
     * @param street
     * @param detailed
     * @param flower_id
     */
    public void addSupplier(@Param("name") String name,
                            @Param("phone") String phone,
                            @Param("email") String email,
                            @Param("province") String province,
                            @Param("city") String city,
                            @Param("street") String street,
                            @Param("detailed") String detailed,
                            @Param("flower_id") int flower_id);


    /**
     * 查找supplier回显到supplier的编辑页面
     *
     * @param id
     * @return
     */
    public Supplier getSupplierById(int id);


    /**
     * 编辑供应商信息
     *
     * @param id
     * @param name
     * @param phone
     * @param email
     * @param province
     * @param city
     * @param street
     * @param detailed
     * @param flower_id
     */
    public void editSupplier(@Param("id") int id,
                             @Param("name") String name,
                             @Param("phone") String phone,
                             @Param("email") String email,
                             @Param("province") String province,
                             @Param("city") String city,
                             @Param("street") String street,
                             @Param("detailed") String detailed,
                             @Param("flower_id") int flower_id);


    /**
     * 通过模糊查询 查找供应商
     *
     * @param suppler_name_key
     * @return
     */
    public List<Supplier> findSupplier(String suppler_name_key);


}
