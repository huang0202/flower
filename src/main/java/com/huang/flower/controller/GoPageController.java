package com.huang.flower.controller;

import com.huang.flower.commons.utils.CookieUtils;
import com.huang.flower.entity.Flower;
import com.huang.flower.entity.Kind;
import com.huang.flower.service.AdminService;
import com.huang.flower.service.FlowerService;
import com.huang.flower.service.KindService;
import com.huang.flower.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class GoPageController {

    @Resource
    private FlowerService flowerService;
    @Resource
    private KindService kindService;
    @Resource
    private AdminService adminService;
    @Resource
    private MailService mailService;


    private static final String COOKIE_NAME_USER_INFO = "userInfoMiYuFlower";

    @GetMapping("/")
    public String index(Map<String, Object> map) {

        List<Kind> allKind = kindService.getAllKind();
        map.put("allKind", allKind);
        return "index";
    }

    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    @GetMapping("/user/login/byEmail")
    public String toLoginByCode() {
        return "loginByCode";
    }


    @GetMapping("/shop")
    public String toShop(Map<String, Object> map) {
        List<Flower> allFlower = flowerService.getAllFlower();
        List<Kind> allKind = kindService.getAllKind();
        map.put("allFlower", allFlower);
        map.put("allKind", allKind);
        return "shop/shop";
    }

    @GetMapping("/main")
    public String toMain() {
        return "main";
    }

    @GetMapping("/user/login")
    public String toUserLogin(HttpSession session, HttpServletRequest req) {
        //跳转到登录页面
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);
        if (userInfo != null && !userInfo.equals("")) {
            String[] userInfoArray = userInfo.split(":");
            String username = userInfoArray[0];
            String password = userInfoArray[1];
            String userType = userInfoArray[2];

            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("userType", userType);
            req.setAttribute("isRemember", true);
        }
        //退出系统清空session信息
        session.invalidate();
        return "login";
    }

}
