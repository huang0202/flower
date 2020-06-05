package com.huang.flower.controller;

import com.huang.flower.entity.Flower;
import com.huang.flower.entity.FlowerOrder;
import com.huang.flower.entity.User;
import com.huang.flower.service.FlowerOrderService;
import com.huang.flower.service.FlowerService;
import com.huang.flower.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlowerOrderController {

    private static Logger logger = LoggerFactory.getLogger(FlowerOrderController.class);

    @Autowired
    private  volatile FlowerOrderService flowerOrderService;
    @Autowired
    private  volatile FlowerService flowerService;
    @Autowired
    private UserService userService;

    @GetMapping("/admin/flowerOrder/flowerOrder")
    public String toFlowerOrder(Map<String, List> map) {
        //查出所有的订单信息
        List<FlowerOrder> allFlowerOrder = flowerOrderService.getAllFlowerOrder();
        map.put("allFlowerOrder", allFlowerOrder);
        return "admin/flowerOrder/flowerOrder";
    }

    /**
     * 花蕊批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/flowerOrder/delete")
    public Map<String, String> adminFlowerOrderDelect(@PathParam("ids") String ids) {
        String[] array = ids.split(",");
        flowerOrderService.deleteFlowerOrder(array);
        Map<String, String> map = new HashMap();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/flowerOrder/add")
    public Map<String, String> adminFlowerOrderAdd(@PathParam("flower_id") String flower_id,
                                                   @PathParam("username") String username,
                                                   @PathParam("num") int num,
                                                   @PathParam("remark") String remark) {

        Map<String, String> map = new HashMap();
        //通过flower_id查找花蕊的基本信息
        Flower flower = flowerService.getFlowerById(Integer.parseInt(flower_id));
        User user = null;
        try {
            user = userService.getUserByUsername(username);
        } catch (Exception e) {
            map.put("msg", "用户名不存在");
            map.put("status", "200");
            return map;
        }
        int user_id = user.getId();
        Double price  = flower.getPrice();
        Date order_time = new Date();
        //添加订单信息
        flowerOrderService.addFlowerOrder(Integer.parseInt(flower_id),user_id,price,num,order_time,remark);
        //更新花蕊库存信息
        flowerService.addStock(Integer.parseInt(flower_id),0 -num);
        map.put("msg", "添加成功");
        map.put("status", "200");
        return map;
    }

    @GetMapping("/admin/flowerOrder/find")
    public String findFlowerOrderByKey(@RequestParam("flowerOrder_flower_name_key") String flowerOrder_flower_name_key,
                                       Map<String, List> map) {
        //模糊查询出所有id
        String[] array = flowerService.getIdsByFlowerKey(flowerOrder_flower_name_key);
        List<FlowerOrder> allFlowerOrder = flowerOrderService.findFlowerOrderByIds(array);
        map.put("allFlowerOrder", allFlowerOrder);
        return "admin/flowerOrder/flowerOrder";
    }

    /**
     *购买花蕊，使用上锁的方式
     * @param user_id
     * @param flower_id
     * @param buyFlowerNum
     * @param flower_price
     * @return
     */
    @ResponseBody
    @PostMapping("/shop/flower/buy")
    public  Map<String, String> userBuyFlower(@PathParam("user_id") int user_id,
                                             @PathParam("flower_id") int flower_id,
                                             @PathParam("buyFlowerNum") int buyFlowerNum,
                                             @PathParam("flower_price") double flower_price){

        Map<String, String> map = new HashMap();
        Date order_time = new Date();
        FlowerOrder flowerOrder = new FlowerOrder(flower_id,user_id,buyFlowerNum,flower_price,order_time,"");
        //添加花蕊订单 信息
        flowerOrderService.buyOneFlower(flowerOrder);
        //修改对应的花蕊库存信息
        int num = -buyFlowerNum;
        flowerService.addStock(flower_id,num);
        map.put("msg", "购买成功，请您及时去花店自取。");
        map.put("status", "200");
        return map;
    }

}
