package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.commonbasic.util.AliPayUtil;
import com.sch.commonbasic.util.SnowUtil;
import com.sch.frontweb.config.RedisUtil;
import com.sch.orderbase.AO.*;
import com.sch.orderbase.VO.OrderDTO;
import com.sch.orderbase.VO.OrderDetailVO;
import com.sch.orderbase.base.OrderBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Description: 订单
 * @Author: chenghao.su
 * @Date: 2020/3/26 15:26
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    HttpSession session;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    private static final String CART_UID = "CART_UID_";
    private Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private static final String ORDER_ID = "ORDER_ID_";
    @Reference
    OrderBaseService orderBaseService;

    /**
     * 提交订单
     * 1.创建订单
     * 2.删除购物车中数据
     *
     * @param orderAO 订单信息
     */
    @PostMapping("/create")
    public void payOrder(@RequestBody @Validated OrderAO orderAO) {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        orderAO.setUserId(userId);
        orderAO.setCode(String.valueOf(SnowUtil.nextId()));
        if (redisUtil.setnx(ORDER_ID + orderAO.getCode(), orderAO.getCode()) == 1) {
            // 1.创建订单
            orderBaseService.createOrder(orderAO);
            // 2.删除购物车中商品
            for (Cart commodity : orderAO.getCartList()) {
                redisUtil.hdel(CART_UID + userId, commodity.getId().toString());
            }
            String form = AliPayUtil.ResponseForm(orderAO.getCode(), orderAO.getTotal(), orderAO.getReceiveName());
            response.setContentType("text/html;charset=utf-8");
            try {
                String str = new ObjectMapper().writeValueAsString(Result.success(form));
                response.getWriter().write(str);
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用户支付订单
     *
     * @param payOrderAO 订单信息
     */
    @PostMapping("/pay")
    public void payOrder(@RequestBody @Validated PayOrderAO payOrderAO) {
        String form = AliPayUtil.ResponseForm(payOrderAO.getCode(), payOrderAO.getTotal(), payOrderAO.getReceiveName());
        response.setContentType("text/html;charset=utf-8");
        try {
            String str = new ObjectMapper().writeValueAsString(Result.success(form));
            response.getWriter().write(str);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支付宝同步跳转
     *
     * @Description: vue支付成功页面
     */
    @GetMapping("/success")
    public void returnUrl() throws IOException {
        LOGGER.info("支付宝同步跳转");
        String order_no = request.getParameter("out_trade_no");

        LOGGER.info("用户支付的订单编号code：{}", order_no);
        OrderStatusAO ao = new OrderStatusAO();
        ao.setCode(order_no);
        ao.setStatus((byte) 1);
        orderBaseService.updateStatus(ao);
        response.sendRedirect("http://localhost:10090/#/feedBack");
    }

    /**
     * 支付宝异步跳转
     *
     * @return vue支付成功页面
     */
    @RequestMapping("/notify")
    public void notifyUrl() throws IOException {
        LOGGER.info("支付宝异步跳转");
        response.sendRedirect("http://localhost:10090/#/feedBack");
    }

    /**
     * 查询用户订单
     *
     * @param searchOrderAO 查询条件
     * @return 用户订单列表
     */
    @ResponseBody
    @GetMapping("/list")
    public Result findUserOrder(@ModelAttribute @Validated SearchOrderAO searchOrderAO) {
        searchOrderAO.setUserId((Long) session.getAttribute(request.getHeader("Authorization")));
        PageInfo<OrderDTO> orderList = orderBaseService.findAll(searchOrderAO);
        return Result.success(orderList);
    }

    /**
     * 修改订单状态
     *
     * @param orderStatusAO 新状态
     */
    @ResponseBody
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
    @ResponseBody
    @GetMapping("/detail")
    public Result findOrderDetail(@RequestParam Long id) {
        List<OrderDetailVO> vos = orderBaseService.findOrderDetailById(id);
        return Result.success(vos);
    }
}
