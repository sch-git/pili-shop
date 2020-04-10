package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.orderbase.AO.OrderStatusAO;
import com.sch.orderbase.AO.SearchOrderAO;
import com.sch.orderbase.VO.OrderDTO;
import com.sch.orderbase.VO.OrderDetailVO;
import com.sch.orderbase.base.OrderBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 订单管理
 * @Author: chenghao.su
 * @Date: 2020/4/8 13:02
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    OrderBaseService orderBaseService;

    /**
     * 查询订单列表
     *
     * @param searchOrderAO 查询条件
     * @return 订单列表
     */
    @GetMapping("/list")
    public Result findList(@ModelAttribute @Validated SearchOrderAO searchOrderAO) {
        PageInfo<OrderDTO> pageInfo = orderBaseService.findAll(searchOrderAO);
        return Result.success(pageInfo);
    }

    /**
     * 修改订单状态
     *
     * @param orderStatusAO 新状态
     */
    @PutMapping("/status")
    public Result updateStatus(@RequestBody @Validated OrderStatusAO orderStatusAO) {
        orderBaseService.updateStatus(orderStatusAO);
        return new Result(ResultEnum.UPDATE_SUCCESS);
    }

    /**
     * 根据订单id查询订单项
     *
     * @param id 订单id
     * @return 订单项集合
     */
    @GetMapping("/detail")
    public Result findOrderDetail(@RequestParam Long id) {
        List<OrderDetailVO> vos = orderBaseService.findOrderDetailById(id);
        return Result.success(vos);
    }
}
