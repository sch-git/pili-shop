package com.sch.orderservice;

import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderbase.base.OrderBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 订单 Service 测试
 * @Author: chenghao.su
 * @Date: 2020/4/8 14:03
 */
@SpringBootTest
public class OrderServiceTest {


    @Autowired
    OrderBaseService orderService;

    @Test
    void findAll() {
        SearchOrderAO ao = new SearchOrderAO();
        ao.setPageNum(1);
        ao.setPageSize(3);
        ao.setProvince("");
        ao.setStatus(null);
        System.out.println(orderService.findAll(ao));
    }

    @Test
    void updateStatus() {
        OrderStatusAO ao = new OrderStatusAO();
        ao.setId(14L);
        ao.setStatus((byte) 2);
        orderService.updateStatus(ao);
    }

    @Test
    void findOrderDetail() {
        System.out.println(orderService.findOrderDetailById(14L));
    }
}
