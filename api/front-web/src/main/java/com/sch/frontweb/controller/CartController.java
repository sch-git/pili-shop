package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.frontweb.config.RedisUtil;
import com.sch.orderbase.AO.AddCartAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    HttpServletRequest request;
    @Reference
    CommodityBaseService commodityBaseService;
    private static final String CART_UID = "CART_UID_";

    /**
     * 根据用户id从缓存中查询取出购物车中的商品id
     *
     * @return 购物车数据
     */
    @PostMapping("/list")
    public Result findCartList() {
        String userId = Long.toString((Long) session.getAttribute(request.getHeader("Authorization")));
        Set<String> commodityIds = redisUtil.hkeys(CART_UID + userId);
        List<CommodityVO> commodityVOS = commodityBaseService.findByIds(commodityIds);
        if (commodityVOS != null) {
            for (CommodityVO vo : commodityVOS) {
                vo.setNumber(redisUtil.hget(CART_UID + userId, vo.getId().toString()));
            }
        }
        return Result.success(commodityVOS);
    }

    /**
     * 商品添加购物车
     *
     * @param addCartAO （商品id，增量）
     * @return
     */
    @PostMapping("/item")
    @Transactional
    public Result addCartItem(@RequestBody AddCartAO addCartAO) {
        String userId = Long.toString((Long) session.getAttribute(request.getHeader("Authorization")));
        String commodityId = String.valueOf(addCartAO.getCommodityId());
        Long inCrement = Long.valueOf(addCartAO.getNumber());
        redisUtil.hincrby(CART_UID + userId, commodityId, inCrement);
        return new Result(ResultEnum.ADD_SUCCESS);
    }

    /**
     * 从缓存中删除购物车中指定商品
     *
     * @param addCartAO 商品id
     * @return
     */
    @DeleteMapping("/delete")
    @Transactional
    public Result deleteCartItem(@ModelAttribute AddCartAO addCartAO) {
        String userId = Long.toString((Long) session.getAttribute(request.getHeader("Authorization")));
        String commodityId = String.valueOf(addCartAO.getCommodityId());
        redisUtil.hdel(CART_UID + userId, commodityId);
        return Result.success();
    }
}
