package com.sch.frontweb.controller;

import com.sch.commonbasic.VO.Result;
import com.sch.frontweb.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 订单
 * @Author: chenghao.su
 * @Date: 2020/3/26 15:26
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    HttpSession session;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/pay")
    public Result payOrder() {
        return Result.success();
    }
}
