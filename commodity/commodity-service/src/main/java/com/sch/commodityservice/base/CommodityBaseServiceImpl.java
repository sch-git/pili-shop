package com.sch.commodityservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commoditybase.exception.CommodityException;
import com.sch.commodityservice.service.CommodityService;
import com.sch.commonbasic.enums.CommodityEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 商品模块外部接口实现
 * @Author: chenghao.su
 * @Date: 2020/2/14 17:38
 */
@Service
public class CommodityBaseServiceImpl implements CommodityBaseService {
    @Autowired
    CommodityService commodityService;

    /**
     * 添加商品
     *
     * @param addCommodityAO 商品信息
     * @return 商品id
     */
    @Override
    public long addCommodity(AddCommodityAO addCommodityAO) {
        if (addCommodityAO == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL);
        }
        if (addCommodityAO.getCategoryId() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_CATEGORYID);
        }
        if (addCommodityAO.getName().isEmpty() || addCommodityAO.getName() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_NAME);
        }
        if (addCommodityAO.getCreateName().isEmpty() || addCommodityAO.getCreateName() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_CREATENAME);
        }
        if (addCommodityAO.getDescribe().isEmpty() || addCommodityAO.getDescribe() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_DESCRIBE);
        }
        if (addCommodityAO.getPrice() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_PRICE);
        }
        if (addCommodityAO.getStatus() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_STATUS);
        }
        if (addCommodityAO.getUrl().isEmpty() || addCommodityAO.getUrl() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_URL);
        }
        return commodityService.addCommodity(addCommodityAO);
    }
}
