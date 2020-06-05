package com.huang.flower.service.impl;

import com.huang.flower.entity.Admin;
import com.huang.flower.entity.User;
import com.huang.flower.mapper.UserMapper;
import com.huang.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 查找用户通过用户名
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if (user == null || user.equals("")){
            throw new RuntimeException("用户名不存在");
        }
        return user;
    }

    @Override
    public void registerUser(String username, String password, String email, String phone) {
        userMapper.registerUser(username,password,email,phone);
    }

    @Override
    public String[] getUserEmails() {
        return userMapper.getUserEmails();
    }

    @Override
    public long getUserIdByUsername(String username) {
        return userMapper.getUserIdByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userMapper.getUserByEmail(email);
        if (user == null){
            throw new RuntimeException("用户名不存在");
        }
        return user;
    }
}
