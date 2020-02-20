package com.sch.commodityservice.dao;

import com.sch.commodityservice.dto.AddCommodityImageDTO;
import org.springframework.stereotype.Repository;

/**
 * @Description: 商品图片DAO
 * @Author: chenghao.su
 * @Date: 2020/2/20 14:43
 */
@Repository
public interface CommodityImageDao {
    /**
     * 添加商品图片
     *
     * @param addCommodityImageDTO 商品图片对象
     * @return 影响行数
     */
    int addCommodityImage(AddCommodityImageDTO addCommodityImageDTO);
}