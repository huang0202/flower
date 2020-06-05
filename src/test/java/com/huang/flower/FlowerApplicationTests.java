package com.huang.flower;

import com.huang.flower.mapper.*;
import com.huang.flower.service.*;
import com.huang.flower.service.impl.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;


@RunWith(SpringRunner.class)

@SpringBootTest
public class FlowerApplicationTests {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MailService mailService;
    @Autowired
    FlowerMapper flowerMapper;
    @Autowired
    KindMapper kindMapper;
    @Autowired
    VipMapper vipMapper;
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    StockPurchaseMapper stockPurchaseMapper;
    @Autowired
    VipService vipService;
    @Autowired
    AdminService adminService;
    @Autowired
    FlowerService flowerService;
    @Autowired
    FlowerCartMapper flowerCartMapper;
    @Autowired
    FlowerOrderMapper flowerOrderMapper;
    @Autowired
    FlowerOrderService flowerOrderService;
    @Autowired
    BouquetMapper bouquetMapper;
    @Autowired
    BouquetFlowerMapper bouquetFlowerMapper;
    @Autowired
    BouquetService bouquetService;

    @Test
    @Transactional
    @Rollback
    public void test(){
        Date order_time = new Date();
       // flowerOrderMapper.buyOneFlower(1,1,2,12.3,order_time,"123");
       // flowerOrderService.buyOneFlower(new FlowerOrder(1,1,1,12.3,order_time,""));
        flowerOrderMapper.test();
    }

    @Test

    public void testBouquetMapper(){
        System.out.println(userMapper.getUserByEmail("1154458742@qq.com"));

    }

    @Test
    @Transactional
    public void testBouquetFlowerMapper() throws Exception{
        //System.out.println(bouquetFlowerMapper.getAllBouquetFlower());
        String[] a={"123"};
        bouquetFlowerMapper.deleteBouquetFlower(a);
        try {
            throw new SQLException("发生异常了..");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
