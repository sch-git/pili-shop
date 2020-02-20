package com.sch.commodityservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.commoditybase.AO.AddCommodityImageAO;
import com.sch.commoditybase.base.CommodityImageBaseService;
import com.sch.commoditybase.exception.CommodityException;
import com.sch.commodityservice.service.CommodityImageService;
import com.sch.commonbasic.enums.CommodityEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 商品图片服务外部接口实现
 * @Author: chenghao.su
 * @Date: 2020/2/20 15:41
 */
@Service
public class CommodityImageBaseServiceImpl implements CommodityImageBaseService {
    @Autowired
    CommodityImageService commodityImageService;

    /**
     * 添加商品图片
     *
     * @param addCommodityImageAO 商品图片对象
     */
    @Override
    public void addCommodityImage(AddCommodityImageAO addCommodityImageAO) {
        if (addCommodityImageAO == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL);
        }
        if (addCommodityImageAO.getCommodityId() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_COMMODITYID);
        }
        if (addCommodityImageAO.getCreateId() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_CREATEID);
        }
        if (addCommodityImageAO.getCreateName().isEmpty() || addCommodityImageAO.getCreateName() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_CREATENAME);
        }
        if (addCommodityImageAO.getUrl().isEmpty() || addCommodityImageAO.getUrl() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_URL);
        }
        commodityImageService.addCommodityImage(addCommodityImageAO);
    }
}
