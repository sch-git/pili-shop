package com.sch.orderservice.service;

import com.sch.orderbase.AO.OrderAO;
import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderbase.VO.OrderDTO;
import com.sch.orderbase.VO.OrderDetailVO;

import java.util.List;

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

    /**
     * 查询订单列表
     *
     * @param searchOrderAO 查询条件
     * @return 订单列表
     */
    List<OrderDTO> findAll(SearchOrderAO searchOrderAO);

    /**
     * 修改订单状态
     *
     * @param orderStatusAO 新状态
     */
    void updateStatus(OrderStatusAO orderStatusAO);

    /**
     * 根据订单id查询订单项
     *
     * @param orderId 订单id
     * @return 订单项集合
     */
    List<OrderDetailVO> findOrderDetailById(Long orderId);
}
