package com.sch.commodityservice.dao;

import com.sch.commodityservice.dto.AddCommodityDTO;

/**
 * @Description: 商品
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
public interface CommodityDao {
    /**
     * 添加商品
     *
     * @param addCommodityDTO 商品信息
     */
    void addCommodity(AddCommodityDTO addCommodityDTO);
}