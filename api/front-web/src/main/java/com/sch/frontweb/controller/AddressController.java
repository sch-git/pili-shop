package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.frontweb.config.RedisUtil;
import com.sch.userbase.AO.AddressAO;
import com.sch.userbase.base.AddressBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 19:21
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    /**
     * 用户默认地址key
     */
    private static final String DEFAULT_ADDRESS = "DEFAULT_ADDRESS_";
    /**
     * 用户默认地址位于redis缓存中数据库的位置
     */
    private static final Integer INDEX_DB = 0;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RedisUtil redisUtil;
    @Reference
    AddressBaseService addressBaseService;

    /**
     * 用户新增地址
     *
     * @param addressAO 新的地址
     */
    @PostMapping("/insert")
    public Result AddAddress(@RequestBody AddressAO addressAO) {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        addressAO.setUserId(userId);
        addressBaseService.addAddress(addressAO);
        redisUtil.setnx(DEFAULT_ADDRESS + userId, addressAO.getDetailedAddress());
        return new Result(ResultEnum.ADD_SUCCESS, redisUtil.get(DEFAULT_ADDRESS + userId, INDEX_DB));
    }

    /**
     * 查询用户地址列表
     *
     * @return 地址列表
     */
    @GetMapping("/list")
    public Result findAddress() {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        return Result.success(addressBaseService.findAddressList(userId));
    }

    /**
     * 获取用户默认地址
     *
     * @return 默认详细地址
     */
    @GetMapping("/default")
    public Result findDefaultAddress() {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        return Result.success(redisUtil.get(DEFAULT_ADDRESS + userId, INDEX_DB));
    }
}
