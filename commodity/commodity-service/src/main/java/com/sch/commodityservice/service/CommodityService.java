package com.sch.commodityservice.service;

import com.sch.commoditybase.AO.AddCommodityAO;

/**
 * @Description: 商品服务
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
public interface CommodityService {
    /**
     * 添加商品
     *
     * @param addCommodityAO 商品信息
     * @return 商品id
     */
    long addCommodity(AddCommodityAO addCommodityAO);
}
