package com.huang.flower.controller;

import com.huang.flower.entity.Flower;
import com.huang.flower.entity.Kind;
import com.huang.flower.service.FlowerService;

import com.huang.flower.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
public class ShopController {
    @Autowired
    private FlowerService flowerService;
    @Autowired
    private KindService kindService;

    @GetMapping("/shop/details")
    public String toShopDetails(@PathParam("id") String id,
                                Map<String ,Object> map){
        Flower flower = flowerService.getFlowerById(Integer.parseInt(id));

        List<Kind> allKind = kindService.getAllKind();
        map.put("allKind",allKind);
        map.put("flower",flower);
        return "shop/shop-details";
    }
}
