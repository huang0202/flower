package com.huang.flower.controller;

import com.huang.flower.entity.Bouquet;
import com.huang.flower.service.BouquetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BouquetController {

    private static Logger logger = LoggerFactory.getLogger(BouquetController.class);

    @Value("${com.huang.localFile:#{null}}")
    private String filepath;

    @Resource
    private BouquetService bouquetService;

    /**
     * 来到花蕊管理页面
     *
     * @param map
     * @return
     */
    @GetMapping("/admin/bouquet/bouquet")
    public String toAdminFlower(Map<String, Object> map) {
        List<Bouquet> allBouquet = bouquetService.getAllBouquet();
        map.put("allBouquet",allBouquet);
        return "admin/bouquet/bouquet";
    }

    /**
     * 花束批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/bouquet/delete")
    public Map<String, String> adminFlowerDelect(@PathParam("ids") String ids) {
        String[] array = ids.split(",");
        //flowerMapper.deleteFlower(array);
        Map<String, String> map = new HashMap();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        return map;
    }


}
