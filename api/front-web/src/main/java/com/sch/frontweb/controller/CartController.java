package com.sch.frontweb.controller;

import com.sch.commonbasic.VO.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description: 前台-购物车接口
 * @Author: chenghao.su
 * @Date: 2020/3/7 14:25
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    HttpSession session;

    /**
     * 根据用户id查询购物车
     *
     * @param id 用户信息
     * @return 购物车数据
     */
    @GetMapping("/list")
    public Result findCartList(@RequestParam Long id) {
        return null;
    }

}
