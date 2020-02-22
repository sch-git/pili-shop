package com.sch.commodityservice.service.impl;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commodityservice.dao.CommodityDao;
import com.sch.commodityservice.dao.CommodityImageDao;
import com.sch.commodityservice.dto.AddCommodityDTO;
import com.sch.commodityservice.dto.AddCommodityImageDTO;
import com.sch.commodityservice.entity.Commodity;
import com.sch.commodityservice.service.CommodityService;
import com.sch.commonbasic.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 商品服务实现
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:44
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityDao commodityDao;
    @Autowired
    CommodityImageDao commodityImageDao;

    /**
     * 添加商品
     *
     * @param addCommodityAO 商品信息
     * @return 商品id
     */
    @Transactional
    @Override
    public long addCommodity(AddCommodityAO addCommodityAO) {
        AddCommodityDTO addCommodityDTO = new AddCommodityDTO();
        addCommodityDTO.setAO(addCommodityAO);
        commodityDao.addCommodity(addCommodityDTO);
        // 添加商品的同时往添加商品图片表添加图片
        AddCommodityImageDTO addCommodityImageDTO = new AddCommodityImageDTO(addCommodityDTO.getId(),
                addCommodityDTO.getUrl(), addCommodityDTO.getCreateId(), addCommodityDTO.getCreateName());
        commodityImageDao.addCommodityImage(addCommodityImageDTO);
        return addCommodityDTO.getId();
    }

    /**
     * 查询商品
     *
     * @param searchCommodityAO 查询条件
     * @return 商品列表
     */
    @Override
    public List<CommodityVO> findAll(SearchCommodityAO searchCommodityAO) {
        List<Commodity> commodities = commodityDao.findAll(searchCommodityAO);
        if (commodities == null) {
            return null;
        }
        List<CommodityVO> commodityVOS = new ArrayList<>();
        for (Commodity commodity : commodities) {
            CommodityVO commodityVO = new CommodityVO();
            BeanUtils.copyProperties(commodity, commodityVO);
            commodityVO.setCreateTime(DateUtil.toString(commodity.getCreateTime()));
            commodityVO.setUpdateTime(DateUtil.toString(commodity.getUpdateTime()));
            commodityVOS.add(commodityVO);
        }
        return commodityVOS;
    }
}
