package com.huang.flower.service.impl;

import com.huang.flower.entity.Admin;
import com.huang.flower.mapper.AdminMapper;
import com.huang.flower.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper  adminMapper;


    /**
     *
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUsername(String username) {
        Admin admin = adminMapper.getAdminByUsername(username);
        if (admin == null || admin.equals("")) {
            throw new RuntimeException("用户名不存在");
        }
        return admin;
    }

    @Override
    public void changePwdByUsername(String username, String password) {
        adminMapper.changePwdByUsername(username,password);
    }

    @Override
    public void registerAdmin(String username, String password, String email, String phone) {
        adminMapper.registerAdmin(username,password,email,phone);
    }

    @Override
    public String[] getAdminEmails() {
        String[] mails = adminMapper.getAdminEmails();
        return mails;
    }
}
