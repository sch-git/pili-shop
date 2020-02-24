package com.sch.commodityservice.service;

import com.sch.commoditybase.AO.AddCommodityImageAO;
import com.sch.commoditybase.VO.CommodityImageVO;

import java.util.List;

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

    /**
     * 根据商品id查询商品图片
     *
     * @param commodityId 商品id
     * @return 图片列表
     */
    List<CommodityImageVO> findImageByCommodityId(Long commodityId);
}
