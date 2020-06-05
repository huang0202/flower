package com.huang.flower.controller;

import com.huang.flower.entity.Kind;
import com.huang.flower.entity.Supplier;
import com.huang.flower.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KindController {

    @Autowired
    private KindService kindService;

    @GetMapping("/admin/flower/kind")
    public String toAdminFlowerKind(Map<String, Object> map) {
        List<Kind> allKind = kindService.getAllKind();
        map.put("allKind", allKind);
        return "admin/flower/kind";
    }

    /**
     * 添加花蕊回显种类信息
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/flower/getAllKind")
    public Map<String, List> getAllKind() {
        List<Kind> allKind = kindService.getAllKind();
        Map<String, List> map = new HashMap<String, List>();
        map.put("allKind", allKind);
        return map;
    }

    /**
     * 花蕊分类批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/kind/delete")
    public Map<String, String> adminFlowerDelect(@PathParam("ids") String ids) {
        String[] array = ids.split(",");
        kindService.deleteKind(array);
        Map<String, String> map = new HashMap();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/kind/add")
    public Map<String, String> adminFlowerAdd(@PathParam("name") String name) {

        Map<String, String> map = new HashMap();
        kindService.addKind(name);
        map.put("status", "200");
        map.put("msg", "添加成功");
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/kind/edit")
    public Map<String, String> adminFlowerEdit(@PathParam("id") String id,
                                               @PathParam("name") String name) {

        Map<String, String> map = new HashMap();
        kindService.editKind(Integer.parseInt(id), name);
        map.put("status", "200");
        map.put("msg", "编辑成功");
        return map;
    }

    @GetMapping("/admin/kind/findByKey")
    public String findSupplierByKey(@RequestParam("kind_name_key") String kind_name_key,
                                    Map<String, Object> map) {
        List<Kind> allKind = kindService.findKindByKey(kind_name_key);
        map.put("allKind", allKind);
        return "admin/flower/kind";
    }
}
