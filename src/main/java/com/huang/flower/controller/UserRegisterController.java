package com.huang.flower.controller;

import com.huang.flower.entity.Admin;
import com.huang.flower.entity.User;
import com.huang.flower.service.AdminService;
import com.huang.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    /**
     * 用户注册验证用户名是否存在
     *
     * @param username
     * @param usertype
     * @return
     */
    @ResponseBody
    @PostMapping("/user/register/verify")
    public Map<String, String> userRegisterVerify(@PathParam("username") String username,
                                                  @PathParam("usertype") String usertype) throws Exception {
        Map<String, String> map = new HashMap();
        if (usertype.equals("admin")) {
            Admin admin = null;
            try {
                admin = adminService.getAdminByUsername(username);
            } catch (Exception e) {
                map.put("status", "200");
                map.put("msg", "true");
        }
            if (admin != null) {
                map.put("status", "200");
                map.put("msg", "false");
            }

        } else {
            User user = null;
            try {
                user = userService.getUserByUsername(username);
            } catch (Exception e) {
                map.put("status", "200");
                map.put("msg", "true");
            }
            if (user != null) {
                map.put("status", "200");
                map.put("msg", "false");
            }

        }

        return map;
    }
}

