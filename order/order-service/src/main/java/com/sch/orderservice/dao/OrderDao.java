package com.sch.orderservice.dao;

import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderbase.VO.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sch
 */
@Repository
public interface OrderDao {
    /**
     * 创建订单
     *
     * @param orderDTO 订单
     */
    void createOrder(OrderDTO orderDTO);

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
}