package com.sch.commodityservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityStatusAO;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commodityservice.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        return commodityService.addCommodity(addCommodityAO);
    }

    /**
     * 查询商品
     *
     * @param searchCommodityAO 查询条件
     * @return 商品列表
     */
    @Override
    public PageInfo<CommodityVO> findCommodityList(SearchCommodityAO searchCommodityAO) {
        Page page = PageHelper.startPage(searchCommodityAO.getPageNum(), searchCommodityAO.getPageSize());
        List<CommodityVO> commodityVOS = commodityService.findAll(searchCommodityAO);
        PageInfo<CommodityVO> pageInfo = new PageInfo<>(commodityVOS);
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
     * 修改商品状态
     *
     * @param updateCommodityStatusAO 修改条件
     */
    @Override
    public void updateCommodityStatus(UpdateCommodityStatusAO updateCommodityStatusAO) {
        commodityService.updateCommodityStatus(updateCommodityStatusAO);
    }

    /**
     * 修改商品信息
     *
     * @param updateCommodityAO 修改条件
     */
    @Override
    public void updateCommodity(UpdateCommodityAO updateCommodityAO) {
        commodityService.updateCommodity(updateCommodityAO);
    }
}
