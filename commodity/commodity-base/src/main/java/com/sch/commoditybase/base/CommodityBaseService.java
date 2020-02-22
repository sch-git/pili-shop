package com.sch.commoditybase.base;

import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.VO.CommodityVO;

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

    /**
     * 查询商品
     *
     * @param searchCommodityAO 查询条件
     * @return 商品列表
     */
    PageInfo<CommodityVO> findCommodityList(SearchCommodityAO searchCommodityAO);
}
