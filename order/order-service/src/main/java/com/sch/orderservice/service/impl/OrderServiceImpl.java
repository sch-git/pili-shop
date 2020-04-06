package com.sch.orderservice.service.impl;

import com.sch.commonbasic.util.DateUtil;
import com.sch.orderbase.AO.Cart;
import com.sch.orderbase.AO.OrderAO;
import com.sch.orderservice.dao.OrderDao;
import com.sch.orderservice.dao.OrderDetailDao;
import com.sch.orderservice.dto.OrderDTO;
import com.sch.orderservice.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 订单
 * @Author: chenghao.su
 * @Date: 2020/3/29 18:27
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao orderDetailDao;

    /**
     * 创建订单
     *
     * @param orderAO
     */
    @Override
    @Transactional
    public void createOrder(OrderAO orderAO) {
        // 构造订单信息
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(orderAO, dto);
        dto.setStatus((byte) 0);
        dto.setCreateTime(DateUtil.createTime());

        // 生成订单
        orderDao.createOrder(dto);
        // 生成订单详情
        List<Cart> carts = new ArrayList<>();
        for (Cart cart : orderAO.getCartList()) {
            Cart cartDto = new Cart();
            BeanUtils.copyProperties(cart, cartDto);
            cartDto.setOrderId(dto.getId());
            carts.add(cartDto);
        }
        orderDetailDao.createOrderDetail(carts);
    }
}
