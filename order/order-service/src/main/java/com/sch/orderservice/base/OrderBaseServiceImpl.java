package com.sch.orderservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.orderbase.AO.OrderAO;
import com.sch.orderbase.base.OrderBaseService;
import com.sch.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 订单服务
 * @Author: chenghao.su
 * @Date: 2020/3/29 18:49
 */
@Service
public class OrderBaseServiceImpl implements OrderBaseService {
    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     *
     * @param orderAO
     */
    @Override
    public void createOrder(OrderAO orderAO) {
        orderService.createOrder(orderAO);
    }
}
