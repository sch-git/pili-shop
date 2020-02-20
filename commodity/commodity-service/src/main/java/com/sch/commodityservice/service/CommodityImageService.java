package com.sch.commodityservice.service;

import com.sch.commoditybase.AO.AddCommodityImageAO;

/**
 * @Description: 商品图片服务
 * @Author: chenghao.su
 * @Date: 2020/2/20 14:38
 */
public interface CommodityImageService {
    /**
     * 添加商品图片
     *
     * @param addCommodityImageAO 商品图片对象
     */
    void addCommodityImage(AddCommodityImageAO addCommodityImageAO);
}
