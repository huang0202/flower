package com.huang.flower.controller;

import com.huang.flower.entity.FlowerCartJoinFlower;
import com.huang.flower.entity.Kind;
import com.huang.flower.service.FlowerCartService;
import com.huang.flower.service.FlowerService;
import com.huang.flower.service.KindService;
import com.huang.flower.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlowerCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlowerCartService flowerCartService;
    @Autowired
    private KindService kindService;

    private  static Logger logger = LoggerFactory.getLogger(FlowerCartController.class);
    /**
     * 来到花蕊管理页面
     *
     * @param map
     * @return
     */
    @GetMapping("/shop/flower/flowerCart")
    public String toFlowerCart(Map<String, Object> map, HttpSession session){
        Object username = session.getAttribute("username");
        long user_id = userService.getUserIdByUsername(username.toString());
        //通过用户购物车里的东西
        List<FlowerCartJoinFlower> allFlowerOfCart = flowerCartService.getAllFlowerCartByUserId((int) user_id);
        //定义总价
        double priceSum = 0;
        for (FlowerCartJoinFlower flowerCartJoinFlower:allFlowerOfCart) {
            priceSum += flowerCartJoinFlower.getSum() * flowerCartJoinFlower.getPrice();
        }
        List<Kind> allKind = kindService.getAllKind();
        logger.info("总价为priceSum = "+priceSum);

        map.put("priceSum",priceSum);
        map.put("allKind", allKind);
        map.put("user_id", user_id);
        map.put("allFlowerOfCart",allFlowerOfCart);
        return "shop/flowerCart";
    }
    @ResponseBody
    @PostMapping("/shop/flower/joinFlowerCart")
    public Map<String, String> adminFlowerAdd(@PathParam("num") long num,
                                              @PathParam("username") String username,
                                              @PathParam("flower_id") long flower_id ){

        Map<String, String> map = new HashMap();

        // 查询用户id
        long user_id = userService.getUserIdByUsername(username);
        flowerCartService.jionFlowerCart(user_id,flower_id,num);
        map.put("status", "200");
        map.put("msg", "添加购物车成功");
        return map;
    }

    @ResponseBody
    @PostMapping("/shop/flower/joinFlowerCart/deleteFlower")
    public Map<String, String> adminFlowerAdd(@PathParam("user_id") long user_id,
                                              @PathParam("flower_id") long flower_id ){

        Map<String, String> map = new HashMap();

        //删除购物车中每一种花蕊
        flowerCartService.flowerOfCartDelete(user_id,flower_id);
        map.put("status", "200");
        map.put("msg", "清除成功！");
        return map;
    }


}
