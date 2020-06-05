package com.huang.flower.mapper;

import com.huang.flower.entity.Vip;

import java.util.List;

public interface VipMapper {

    /**
     * 查出所有的vip
     *
     * @return
     */
    public List<Vip> getAllVip();

    /**
     * 批量vip信息
     *
     * @param array
     */
    public void deleteVip(String[] array);

    /**
     * 通过用户的id升级成会员
     *
     * @param id
     */
    public void addVip(int id);

    /**
     * 查找是否为会员
     *
     * @param id
     * @return
     */
    public Vip getVipId(int id);


}
