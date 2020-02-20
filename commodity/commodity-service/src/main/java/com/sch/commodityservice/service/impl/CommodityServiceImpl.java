package com.sch.commodityservice.service.impl;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commodityservice.dao.CommodityDao;
import com.sch.commodityservice.dto.AddCommodityDTO;
import com.sch.commodityservice.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 商品服务实现
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:44
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityDao commodityDao;

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
        // TODO 添加商品的同时往添加商品图片表添加图片
        return addCommodityDTO.getId();
    }
}
