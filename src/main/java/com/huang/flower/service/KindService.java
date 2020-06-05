package com.huang.flower.service;

import com.huang.flower.entity.Kind;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KindService {
    /**
     * 查出所有的花的种类
     *
     * @return
     */
    public List<Kind> getAllKind();

    /**
     * 批量删除花蕊分类信息
     *
     * @param array
     */
    public void deleteKind(String[] array);

    /**
     * 新增花蕊分类
     *
     * @param name
     */
    public void addKind(String name);


    /**
     * 编辑分类信息
     *
     * @param id
     * @param name
     */
    public void editKind(@Param("id") int id,@Param("name") String name);

    /**
     * 通过种类的名称模糊查询
     *
     * @param kind_name_key
     * @return
     */
    public List<Kind>  findKindByKey(String kind_name_key);
}
