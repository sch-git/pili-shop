package com.sch.commodityservice.dao;

import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commodityservice.dto.AddCommodityDTO;
import com.sch.commodityservice.dto.CommodityDetailDTO;
import com.sch.commodityservice.dto.UpdateCommodityDTO;
import com.sch.commodityservice.dto.UpdateCommodityStatusDTO;
import com.sch.commodityservice.entity.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Description: 商品
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
@Repository
public interface CommodityDao {
    /**
     * 添加商品
     *
     * @param addCommodityDTO 商品信息
     */
    void addCommodity(AddCommodityDTO addCommodityDTO);

    /**
     * 查询商品
     *
     * @param searchCommodityAO 查询条件
     * @return 商品列表
     */
    List<Commodity> findAll(SearchCommodityAO searchCommodityAO);

    /**
     * 修改商品状态
     *
     * @param updateCommodityStatusDTO 修改条件
     */
    void updateCommodityStatus(UpdateCommodityStatusDTO updateCommodityStatusDTO);

    /**
     * 修改商品信息
     *
     * @param updateCommodityDTO 修改条件
     */
    void updateCommodity(UpdateCommodityDTO updateCommodityDTO);

    /**
     * 根据id查询商品详情
     *
     * @param id 商品id
     * @return 商品详情（包括分类名，商品图片）
     */
    List<CommodityDetailDTO> findById(Long id);

    /**
     * 根据商品id列表查询
     *
     * @param commodityIds 商品id集合
     * @return 商品列表
     */
    List<Commodity> findByIds(Set<String> commodityIds);
}