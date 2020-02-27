package com.sch.commodityservice.dao;

import com.sch.commodityservice.dto.AddCommodityImageDTO;
import com.sch.commodityservice.entity.CommodityImage;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据商品id查询所有图片
     *
     * @param commodityId 商品id
     * @return 图片列表
     */
    List<CommodityImage> findImageByCommodityId(Long commodityId);

    /**
     * 根据id删除图片
     *
     * @param id 图片id
     */
    void deleteImageById(Long id);
}