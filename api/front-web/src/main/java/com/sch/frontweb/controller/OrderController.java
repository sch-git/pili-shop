package com.sch.frontweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.util.AliPayUtil;
import com.sch.commonbasic.util.SnowUtil;
import com.sch.frontweb.config.RedisUtil;
import com.sch.orderbase.AO.OrderAO;
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
    private Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /**
     * TODO 提交订单
     *
     * @param orderAO 订单信息
     */
    @PostMapping("/pay")
    public Result payOrder(@RequestBody OrderAO orderAO) {
        String form = AliPayUtil.ResponseForm(String.valueOf(SnowUtil.nextId()), orderAO.getTotal(), orderAO.getReceiveName());
        response.setContentType("text/html;charset=utf-8");
        try {
            String str = new ObjectMapper().writeValueAsString(Result.success(form));
            response.getWriter().write(str);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }

    /**
     * 支付宝同步跳转
     *
     * @return vue支付成功页面
     */
    @GetMapping("/success")
    public void returnUrl() throws IOException {
        LOGGER.info("支付宝同步跳转");
        response.sendRedirect("http://localhost:10090/#/feedBack");
    }

    /**
     * 支付宝异步跳转
     *
     * @return vue支付成功页面
     */
    @PostMapping("/success")
    public void notifyUrl() throws IOException {
        LOGGER.info("支付宝异步跳转");
        response.sendRedirect("http://localhost:10090/#/feedBack");
    }
}
