package com.sch.commoditybase.base;

import com.sch.commoditybase.AO.AddCommodityAO;

/**
 * @Description: 商品模块外部接口
 * @Author: chenghao.su
 * @Date: 2020/2/14 16:15
 */
public interface CommodityBaseService {
    /**
     * 添加商品
     *
     * @param addCommodityAO 商品信息
     * @return 商品id
     */
    long addCommodity(AddCommodityAO addCommodityAO);
}
