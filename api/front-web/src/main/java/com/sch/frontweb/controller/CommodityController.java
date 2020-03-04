package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commoditybase.base.CommodityImageBaseService;
import com.sch.commonbasic.VO.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 前台-商品接口
 * @Author: chenghao.su
 * @Date: 2020/3/1 15:06
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Reference(timeout = 60000)
    CommodityBaseService commodityBaseService;
    @Reference(timeout = 60000)
    CommodityImageBaseService commodityImageBaseService;

    /**
     * 查询商品
     *
     * @param searchCommodityAO 查询条件
     * @return 商品列表
     */
    @GetMapping("/list")
    public Result findCommodityList(@ModelAttribute SearchCommodityAO searchCommodityAO) {
        PageInfo<CommodityVO> pageInfo = commodityBaseService.findCommodityList(searchCommodityAO);
        return Result.success(pageInfo);
    }

    /**
     * 根据id查询商品详情
     *
     * @param commodityId 商品id
     * @return 商品详情（包括分类名，商品图片）
     */
    @GetMapping("/item")
    public Result findCommodityById(@RequestParam Long commodityId) {
        return Result.success(commodityBaseService.findById(commodityId));
    }
}
