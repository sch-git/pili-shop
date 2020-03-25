package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.frontweb.config.RedisUtil;
import com.sch.userbase.AO.AddressAO;
import com.sch.userbase.VO.AddressVO;
import com.sch.userbase.VO.InsertAddressVO;
import com.sch.userbase.base.AddressBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
    public Result AddAddress(@RequestBody @Validated AddressAO addressAO) {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        addressAO.setUserId(userId);
        Long id = addressBaseService.addAddress(addressAO);

        redisUtil.setnx(DEFAULT_ADDRESS + userId, Long.toString(id));

        InsertAddressVO vo = new InsertAddressVO();
        vo.setId(id);
        vo.setDefaultId(Long.valueOf(redisUtil.get(DEFAULT_ADDRESS + userId, INDEX_DB)));
        return new Result(ResultEnum.ADD_SUCCESS, vo);
    }

    /**
     * 查询用户地址列表
     *
     * @return 地址列表
     */
    @PostMapping("/list")
    public Result findAddress() {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        return Result.success(addressBaseService.findAddressList(userId));
    }

    /**
     * 获取用户默认地址
     *
     * @return 默认详细地址
     */
    @PostMapping("/default")
    public Result findDefaultAddress() {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        AddressVO addressVO = addressBaseService.findAddressById(Long.valueOf(redisUtil.get(DEFAULT_ADDRESS + userId, INDEX_DB)));
        return Result.success(addressVO);
    }

    /**
     * 用户修改默认地址
     *
     * @param map 新默认地址id
     */
    @PutMapping("/default")
    public Result updateDefaultAddress(@RequestBody Map<String, String> map) {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        // 删除旧的默认地址
        redisUtil.del(DEFAULT_ADDRESS + userId);
        // 设置新的默认地址
        redisUtil.setnx(DEFAULT_ADDRESS + userId, map.get("id"));
        return Result.success();
    }

    /**
     * 用户删除地址
     *
     * @param id 被删除的地址id
     */
    @DeleteMapping("/delete")
    public Result deleteAddress(@RequestParam Long id) {
        addressBaseService.deleteAddressById(id);
        return Result.success();
    }

    /**
     * 用户修改地址
     *
     * @param addressAO 修改后的地址信息
     */
    @PutMapping("/update")
    public Result updateAddress(@RequestBody @Validated AddressAO addressAO) {
        addressBaseService.updateAddressById(addressAO);
        return new Result(ResultEnum.UPDATE_SUCCESS);
    }
}
