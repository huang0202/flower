package com.huang.flower.controller;

import com.huang.flower.entity.Flower;
import com.huang.flower.entity.StockPurchase;
import com.huang.flower.entity.Supplier;
import com.huang.flower.service.FlowerService;
import com.huang.flower.service.StockPurchaseService;
import com.huang.flower.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.net.Inet4Address;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StockPurchaseController {

    @Autowired
    private StockPurchaseService stockPurchaseService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private FlowerService flowerService;

    /**
     * 跳转供应记录页面
     *
     * @param map
     * @return
     */
    @GetMapping("/admin/stockPurchase/stockPurchase")
    public String toAdminStockPurchase(Map<String, Object> map) {
        List<StockPurchase> allStockPurchase = stockPurchaseService.getAllStockPurchase();
        map.put("allStockPurchase", allStockPurchase);
        return "admin/stockPurchase/stockPurchase";
    }

    /**
     * 花蕊供应记录批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/stockPurchase/delete")
    public Map<String, String> adminFlowerDelect(@PathParam("ids") String ids) {
        String[] array = ids.split(",");
        stockPurchaseService.deleteStockPurchase(array);
        Map<String, String> map = new HashMap();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        return map;
    }


    /**
     * 添加供应记录的信息回显
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/flower/getAllFlowerAndSupplier")
    public Map<String, List> getAllFlower() {
        List<Flower> allFlower = flowerService.getAllFlower();
        List<Supplier> allSupplier = supplierService.getAllSupplier();
        Map<String, List> map = new HashMap<String, List>();
        map.put("allFlower", allFlower);
        map.put("allSupplier", allSupplier);
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/stockPurchase/add")
    public Map<String, String> StockPurchaseAdd(@PathParam("flower_id") String flower_id,
                                                @PathParam("supplier_id") String supplier_id,
                                                @PathParam("num") String num,
                                                @PathParam("price") String price,
                                                @PathParam("remark") String remark,
                                                @PathParam("state") String state) {

        Map<String, String> map = new HashMap();
        Date purchaseTime = new Date();
        //添加供应记录
        stockPurchaseService.addStockPurchase(Integer.parseInt(flower_id), Integer.parseInt(supplier_id),
                Integer.parseInt(num), Double.parseDouble(price),
                purchaseTime, remark, Integer.parseInt(state));
        //添加库存
        flowerService.addStock(Integer.parseInt(flower_id), Integer.parseInt(num));
        map.put("status", "200");
        map.put("msg", "添加成功");
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/stockPurchase/getStockPurchaseById")
    public Map<String, Object> getStockPurchaseById(@PathParam("id") String id) {
        StockPurchase stockPurchase = stockPurchaseService.getStockPurchaseById(Integer.parseInt(id));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stockPurchase", stockPurchase);
        return map;
    }

    @ResponseBody
    @PostMapping("/admin/stockPurchase/edit")
    public Map<String, String> StockPurchaseedit(@PathParam("id") String id,
                                                 @PathParam("flower_id") String flower_id,
                                                 @PathParam("supplier_id") String supplier_id,
                                                 @PathParam("num") String num,
                                                 @PathParam("price") String price,
                                                 @PathParam("remark") String remark,
                                                 @PathParam("state") String state) {

        Map<String, String> map = new HashMap();

        //编辑供应记录
        stockPurchaseService.editStockPurchase(Integer.parseInt(id), Integer.parseInt(flower_id),
                Integer.parseInt(supplier_id), Integer.parseInt(num),
                Double.parseDouble(price), remark, Integer.parseInt(state));
        map.put("status", "200");
        map.put("msg", "编辑成功");
        return map;
    }

    @GetMapping("/admin/stockPurchase/find")
    public String findStockPurchaseByFlowerNamekey(@RequestParam("stockPurchase_flower_name_key") String stockPurchase_flower_name_key,
                                                   Map<String, Object> map) {
        String[] array = flowerService.getIdsByFlowerKey(stockPurchase_flower_name_key);
        if(array.length < 1){
            return "admin/stockPurchase/stockPurchase";
        }
        List<StockPurchase> allStockPurchase = stockPurchaseService.findStockPurchaseByFlowerIds(array);
        map.put("allStockPurchase", allStockPurchase);
        return "admin/stockPurchase/stockPurchase";
    }

}
