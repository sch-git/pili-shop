package com.sch.orderservice.dao;

import com.sch.orderbase.AO.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {
    /**
     * 创建订单详情
     *
     * @param carts 商品列表
     */
    void createOrderDetail(List<Cart> carts);
}