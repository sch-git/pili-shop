package com.sch.orderservice.dao;

import com.sch.orderbase.AO.Cart;
import com.sch.orderbase.VO.OrderDetailVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {
    /**
     * 创建订单项
     *
     * @param carts 商品列表
     */
    void createOrderDetail(List<Cart> carts);

    /**
     * 根据订单id查询订单项
     *
     * @param orderId 订单id
     * @return 订单项集合
     */
    List<OrderDetailVO> findOrderDetailById(Long orderId);
}