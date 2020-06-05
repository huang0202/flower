package com.huang.flower.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SignOutController {

    @GetMapping("/signOut")
    public String signOut(HttpSession session){
      //退出系统清空session信息
        session.invalidate();
        return "index";
    }
}
