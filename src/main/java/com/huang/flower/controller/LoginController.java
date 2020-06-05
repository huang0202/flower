package com.huang.flower.controller;

import com.huang.flower.commons.utils.CookieUtils;
import com.huang.flower.entity.Admin;
import com.huang.flower.entity.User;
import com.huang.flower.service.AdminService;
import com.huang.flower.service.FlowerService;
import com.huang.flower.service.UserService;
import com.huang.flower.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private FlowerService flowerService;






    private static final String COOKIE_NAME_USER_INFO = "userInfoMiYuFlower";

    @PostMapping("/user/login")
    public String login(@PathParam("username") String username,
                        @PathParam("password") String password,
                        @PathParam("userType") String userType,
                        @PathParam("isremember") String isremember,
                        HttpServletRequest req,
                        HttpServletResponse resp,
                        HttpSession session,
                        Map<String, Object> map) throws Exception {

        boolean isRemember = isremember == null ? false : true;
        //用户选择不记住密码
        if (!isRemember) {
            CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
        }
        if ("admin".equals(userType)) {
            //登录者的身份是花店管理员
            try {
                adminService.getAdminByUsername(username);
            } catch (Exception e) {
                System.out.println("用户名不存在");
                map.put("msg", "用户名不存在");
                return "login";
            }
            Admin admin = adminService.getAdminByUsername(username);
            if (!StringUtils.isEmpty(admin.getUsername())) {
                //表示用户名存在
                if (password.equals(admin.getPassword())) {
                    //密码正确
                    //密码正确,登陆成功
                    //登陆成功将数据存入cookie
                    if (isRemember) {
                        CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s:%s", username, password, userType), 7 * 24 * 60 * 60);
                    }
                    session.setAttribute("username", username);
                    map.put("username", username);
                    map.put("usertype", userType);
                    map.put("msg", "登录成功");
                    //用户登录成功，发送邮件提示
                    String mail = admin.getEmail();
                    new Thread(() -> mailService.userLoginMail(username, mail)).start();
                    String[] mails = adminService.getAdminEmails();
                    String[] flowersOfLess = flowerService.getFlowerOfStockLessNum(15);
                    map.put("flowersOfLess",flowersOfLess);
                    if (flowersOfLess.length >=  1) {
                        new Thread(() -> mailService.FlowerLess(mails, flowersOfLess)).start(); //新建一个线程发送邮箱提示花蕊库存不足
                    }
                    return "redirect:/main";
                } else {
                    map.put("msg", "密码错误");
                    return "login";
                }
            } else {
                map.put("msg", "用户名不存在");
                return "login";
            }
        }
        if ("user".equals(userType)) {
            //登录者的身份是普通用户
            try {
                userService.getUserByUsername(username);
            } catch (Exception e) {
                map.put("msg", "用户名不存在");
                return "login";
            }
            User user = userService.getUserByUsername(username);
            if (!StringUtils.isEmpty(user.getUsername())) {
                //表示用户名存在
                if (password.equals(user.getPassword())) {
                    //密码正确
                    //密码正确,登陆成功
                    //登陆成功将数据存入cookie
                    if (isRemember) {
                        CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s:%s", username, password, userType), 7 * 24 * 60 * 60);
                    }
                    session.setAttribute("username", username);
                    session.setAttribute("user_id",user.getId());
                    map.put("username", username);
                    map.put("usertype", userType);
                    map.put("msg", "登录成功");
                    //用户登录成功，发送邮件提示
                    String mail = user.getEmail();
                    new Thread(() -> mailService.userLoginMail(username, mail)).start();
                    return "redirect:/";
                } else {
                    map.put("msg", "密码错误");
                    return "login";
                }
            } else {
                map.put("msg", "用户名不存在");
                return "login";
            }
        }
        map.put("msg", "系统错误");
        return "123";
    }
}

