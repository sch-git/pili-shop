package com.sch.orderservice;

import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderservice.dao.OrderDao;
import com.sch.orderservice.dao.OrderDetailDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 订单DAO测试
 * @Author: chenghao.su
 * @Date: 2020/4/8 13:54
 */
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao orderDetailDao;

    @Test
    void findAll() {
        SearchOrderAO ao = new SearchOrderAO();
        ao.setProvince("");
        ao.setStatus(null);
        System.out.println(orderDao.findAll(ao));
    }

    @Test
    void updateStatus() {
        OrderStatusAO ao = new OrderStatusAO();
        ao.setId(14L);
        ao.setStatus((byte) 2);
        orderDao.updateStatus(ao);
    }

    @Test
    void findOrderDetail() {
        System.out.println(orderDetailDao.findOrderDetailById(16L));

    }
}
