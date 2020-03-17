package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.frontweb.config.RedisUtil;
import com.sch.orderbase.AO.AddCartAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

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
    @Autowired
    RedisUtil redisUtil;
    @Reference
    CommodityBaseService commodityBaseService;

    /**
     * 根据用户id从缓存中查询取出购物车中的商品id
     *
     * @param id 用户信息
     * @return 购物车数据
     */
    @GetMapping("/list")
    public Result findCartList(@RequestParam Long id) {
        String userId = (String) session.getAttribute(session.getId());
        Set<String> commodityIds = redisUtil.hkeys(userId);
        List<CommodityVO> commodityVOS = commodityBaseService.findByIds(commodityIds);
        for (CommodityVO vo : commodityVOS) {
            vo.setNumber(redisUtil.hget(userId, String.valueOf(vo.getId())));
        }
        return Result.success(commodityVOS);
    }

    /**
     * 商品添加购物车
     *
     * @param addCartAO （商品id，添加数量）
     * @return
     */
    @PostMapping("/item")
    @Transactional
    public Result addCartItem(@RequestBody AddCartAO addCartAO) {
        String userId = (String) session.getAttribute(session.getId());
        String commodityId = String.valueOf(addCartAO.getCommodityId());
        Long inCrement = Long.valueOf(addCartAO.getNumber());
        redisUtil.hincrby(userId, commodityId, inCrement);
        return Result.success();
    }
}
