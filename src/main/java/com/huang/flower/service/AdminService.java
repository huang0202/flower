package com.huang.flower.service;

import com.huang.flower.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface  AdminService {


    /**
     *  通过用户名查找出admin
     * @param username
     * @return
     */
    public Admin getAdminByUsername(String  username);

    /**
     * 通过用户名修改密码
     *
     * @param username
     * @param password
     */
    public void changePwdByUsername(@Param("username") String username,
                                    @Param("password") String password);

    /**
     * 注册用户
     * @param username
     * @param password
     * @param email
     * @param phone
     */
    public void registerAdmin(@Param("username") String username,
                             @Param("password") String password,
                             @Param("email") String email,
                             @Param("phone") String phone);
    /**
     * 查询所有管理员的邮箱
     *
     * @return
     */
    public String[] getAdminEmails();

}
