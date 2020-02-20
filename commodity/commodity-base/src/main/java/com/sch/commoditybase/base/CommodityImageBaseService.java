package com.sch.commoditybase.base;

import com.sch.commoditybase.AO.AddCommodityImageAO;

/**
 * @Description: 商品图片服务外部接口
 * @Author: chenghao.su
 * @Date: 2020/2/20 15:38
 */
public interface CommodityImageBaseService {
    /**
     * 添加商品图片
     *
     * @param addCommodityImageAO 商品图片对象
     */
    void addCommodityImage(AddCommodityImageAO addCommodityImageAO);
}
