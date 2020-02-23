package com.sch.commoditybase.base;

import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityStatusAO;
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

    /**
     * 修改商品状态
     *
     * @param updateCommodityStatusAO 修改条件
     */
    void updateCommodityStatus(UpdateCommodityStatusAO updateCommodityStatusAO);

    /**
     * 修改商品信息
     *
     * @param updateCommodityAO 修改条件
     */
    void updateCommodity(UpdateCommodityAO updateCommodityAO);
}
