package com.sch.orderservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.orderbase.AO.OrderAO;
import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderbase.VO.OrderDTO;
import com.sch.orderbase.VO.OrderDetailVO;
import com.sch.orderbase.base.OrderBaseService;
import com.sch.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    /**
     * 查询订单列表
     *
     * @param searchOrderAO 查询条件
     * @return 订单列表
     */
    @Override
    public PageInfo<OrderDTO> findAll(SearchOrderAO searchOrderAO) {
        Page page = PageHelper.startPage(searchOrderAO.getPageNum(), searchOrderAO.getPageSize());
        List<OrderDTO> orderDTOS = orderService.findAll(searchOrderAO);
        PageInfo<OrderDTO> pageInfo = new PageInfo<>(orderDTOS);
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
     * 修改订单状态
     *
     * @param orderStatusAO 新状态
     */
    @Override
    public void updateStatus(OrderStatusAO orderStatusAO) {
        orderService.updateStatus(orderStatusAO);
    }

    /**
     * 根据订单id查询订单项
     *
     * @param orderId 订单id
     * @return 订单项集合
     */
    @Override
    public List<OrderDetailVO> findOrderDetailById(Long orderId) {
        return orderService.findOrderDetailById(orderId);
    }
}
