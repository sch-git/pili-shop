package com.sch.commodityservice.service.impl;

import com.sch.commoditybase.AO.AddCommodityImageAO;
import com.sch.commodityservice.dao.CommodityImageDao;
import com.sch.commodityservice.dto.AddCommodityImageDTO;
import com.sch.commodityservice.service.CommodityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 商品图片服务实现
 * @Author: chenghao.su
 * @Date: 2020/2/20 14:38
 */
@Service
public class CommodityImageServiceImpl implements CommodityImageService {
    @Autowired
    CommodityImageDao commodityImageDao;

    /**
     * 添加商品图片
     *
     * @param addCommodityImageAO 商品图片对象
     */
    @Transactional
    @Override
    public void addCommodityImage(AddCommodityImageAO addCommodityImageAO) {
        AddCommodityImageDTO dto = new AddCommodityImageDTO();
        dto.setAO(addCommodityImageAO);
        commodityImageDao.addCommodityImage(dto);
    }
}
