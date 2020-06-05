package com.huang.flower.controller;

import com.huang.flower.entity.Admin;
import com.huang.flower.service.AdminService;
import com.huang.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import java.util.Map;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    /**
     * 跳转到修改密码页面
     *
     * @return
     */
    @GetMapping("/admin/pwd/change")
    public String toAdminPwdChange() {
        return "admin/pwd/pwdChange";
    }

    /**
     * 修改密码
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/admin/pwd/change")
    public String adminPwdChange(@PathParam("username") String username,
                                 @PathParam("password") String password,
                                 @PathParam("erificationpPssword") String erificationpPssword,
                                 Map<String, String> map) {
        Admin admin = adminService.getAdminByUsername(username);
        if (admin.getPassword().equals(erificationpPssword)) {
            adminService.changePwdByUsername(username, password);
            map.put("msg", "密码修改成功,请重新登录");
            return "redirect:/user/login";
        } else {
            map.put("msg", "密码错误请重试!");
            return "admin/pwd/pwdChange";
        }

    }

    @PostMapping("user/register")
    public String userRegister(@PathParam("username") String username,
                               @PathParam("password") String password,
                               @PathParam("email") String email,
                               @PathParam("phone") String phone,
                               @PathParam("usertype") String usertype) {


        if (usertype.equals("user")) {
            userService.registerUser(username, password, email, phone);
        } else if (usertype.equals("admin")) {
            adminService.registerAdmin(username, password, email, phone);
        } else {
            return "register";
        }
        return "redirect:/user/login";
    }


}
