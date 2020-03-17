package com.sch.orderservice.base;

import com.sch.orderbase.AO.AddCartAO;
import com.sch.orderbase.base.CartBaseService;

import java.util.List;

/**
 * @Description: 购物车实现类
 * @Author: chenghao.su
 * @Date: 2020/3/7 16:58
 */
public class CartBaseServiceImpl implements CartBaseService {
    /**
     * 添加购物车
     *
     * @param addCartAO 购物车里的商品信息
     */
    @Override
    public void addCart(AddCartAO addCartAO) {

    }

    /**
     * 根据用户id查询购物车
     *
     * @param id 用户id
     * @return 购物车数据
     */
    @Override
    public List<AddCartAO> findCart(Long id) {
        return null;
    }
}
