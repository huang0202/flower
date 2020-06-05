package com.huang.flower.controller;

import com.huang.flower.entity.Vip;
import com.huang.flower.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VipController {

    @Autowired
    VipService vipService;


    /**
     * 跳转到vip页面
     *
     * @param map
     * @return
     */
    @GetMapping("/admin/vip/vip")
    public String toMainVip(Map<String, Object> map) {
        List<Vip> allVip = vipService.getAllVip();
        map.put("allVip", allVip);
        return "admin/vip/vip";
    }

    /**
     * vip批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/vip/delete")
    public Map<String, String> adminFlowerDelect(@PathParam("ids") String ids) {
        String[] array = ids.split(",");
        vipService.deleteVip(array);
        Map<String, String> map = new HashMap();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        return map;
    }

    /**
     * 添加会员
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/vip/add")
    public Map<String, String> adminFlowerAdd(@PathParam("id") String id) {

        Map<String, String> map = new HashMap();
        vipService.addVip(Integer.parseInt(id));
        map.put("status", "200");
        map.put("msg", "添加成功");
        return map;
    }
}
