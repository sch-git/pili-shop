package com.sch.orderservice.dao;

import com.sch.orderservice.dto.OrderDTO;
import org.springframework.stereotype.Repository;

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
}