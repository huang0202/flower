package com.huang.flower.mapper;

import com.huang.flower.entity.Flower;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FlowerMapper {

    /**
     * 得到所有花蕊的信息
     *
     * @return
     */
    public List<Flower> getAllFlower();

    /**
     * 模糊查询花 通过花的名字
     *
     * @return
     */
    public List<Flower> findFlower(String name);

    /**
     * 批量删除花蕊信息
     *
     * @param array
     */
    public void deleteFlower(String[] array);


    /**
     * 新增花蕊
     *
     * @param name
     * @param price
     * @param stock
     * @param remark
     * @param img
     * @param kind_id
     */
    public void addFlower(@Param("name") String name,
                          @Param("price") Double price,
                          @Param("stock") int stock,
                          @Param("remark") String remark,
                          @Param("img") String  img,
                          @Param("kind_id") int kind_id);

    /**
     * 通过id查找花蕊信息
     *
     * @param id
     * @return
     */
    public Flower getFlowerById(int id);

    /**
     * 编辑花蕊信息
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param remark
     * @param img
     * @param kind_id
     */
    public void editFlower(@Param("id") int id,
                           @Param("name") String name,
                           @Param("price") Double price,
                           @Param("stock") int stock,
                           @Param("remark") String remark,
                           @Param("img") String  img,
                           @Param("kind_id") int kind_id);


    /**
     * 添加花蕊的库存
     *
     * @param id
     * @param num
     */
    public void addStock(@Param("id") int id, @Param("num") int num);


    /**
     * 通过花蕊种类id查找花蕊
     *
     * @param kind_id
     * @return
     */
    public List<Flower> getFlowerByKindId(int kind_id);

    /**
     * 查询花蕊数量少于Minimum的所有花蕊
     *
     * @param minimum
     * @return
     */
    public String[] getFlowerOfStockLessNum(int minimum);


    /**
     * 通过花蕊名称模糊查询出ids
     *
     * @param flower_name_key
     * @return
     */
    public String [] getIdsByFlowerKey(String flower_name_key);


}
