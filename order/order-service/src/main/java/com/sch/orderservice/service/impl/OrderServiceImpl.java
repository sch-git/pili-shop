package com.sch.orderservice.service.impl;

import com.sch.commonbasic.util.DateUtil;
import com.sch.orderbase.AO.Cart;
import com.sch.orderbase.AO.OrderAO;
import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderbase.VO.OrderDTO;
import com.sch.orderbase.VO.OrderDetailVO;
import com.sch.orderservice.dao.OrderDao;
import com.sch.orderservice.dao.OrderDetailDao;
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

    /**
     * 查询订单列表
     *
     * @param searchOrderAO 查询条件
     * @return 订单列表
     */
    @Override
    public List<OrderDTO> findAll(SearchOrderAO searchOrderAO) {
        return orderDao.findAll(searchOrderAO);
    }

    /**
     * 修改订单状态
     *
     * @param orderStatusAO 新状态
     */
    @Override
    public void updateStatus(OrderStatusAO orderStatusAO) {
        orderDao.updateStatus(orderStatusAO);
    }

    /**
     * 根据订单id查询订单项
     *
     * @param orderId 订单id
     * @return 订单项集合
     */
    @Override
    public List<OrderDetailVO> findOrderDetailById(Long orderId) {
        return orderDetailDao.findOrderDetailById(orderId);
    }
}
