package com.sch.orderservice.service;

import com.sch.orderbase.AO.OrderAO;

/**
 * @Description: 订单
 * @Author: chenghao.su
 * @Date: 2020/3/29 18:27
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderAO
     */
    void createOrder(OrderAO orderAO);
}
