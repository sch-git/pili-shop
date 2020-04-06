package com.sch.orderbase.base;

import com.sch.orderbase.AO.OrderAO;

/**
 * @Description: 订单服务
 * @Author: chenghao.su
 * @Date: 2020/3/29 18:48
 */
public interface OrderBaseService {
    /**
     * 创建订单
     *
     * @param orderAO
     */
    void createOrder(OrderAO orderAO);
}
