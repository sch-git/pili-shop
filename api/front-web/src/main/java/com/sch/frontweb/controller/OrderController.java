package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.util.AliPayUtil;
import com.sch.commonbasic.util.SnowUtil;
import com.sch.frontweb.config.RedisUtil;
import com.sch.orderbase.AO.Cart;
import com.sch.orderbase.AO.OrderAO;
import com.sch.orderbase.base.OrderBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    @PostMapping("/pay")
    public void payOrder(@RequestBody OrderAO orderAO) {
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
     * 支付宝同步跳转
     *
     * @Description: vue支付成功页面
     */
    @GetMapping("/success")
    public void returnUrl() throws IOException {
        LOGGER.info("支付宝同步跳转");
        System.out.println(request.getRequestURI());
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
}
