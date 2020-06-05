package com.huang.flower.mapper;


import com.huang.flower.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 通过用户名查找出User
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username);


    /**
     * 通过用户邮箱查找用户名
     * @param email
     * @return
     */
    public User getUserByEmail(String email);


    /**
     * 注册用户
     *
     * @param username
     * @param password
     * @param email
     * @param phone
     */
    public void registerUser(@Param("username") String username,
                             @Param("password") String password,
                             @Param("email") String email,
                             @Param("phone") String phone);


    /**
     * 查询所有用户的邮箱
     *
     * @return
     */
    public String[] getUserEmails();


    /**
     * 通过用户名查询用户id
     *
     * @param username
     * @return
     */
    public long  getUserIdByUsername(String username);
}
