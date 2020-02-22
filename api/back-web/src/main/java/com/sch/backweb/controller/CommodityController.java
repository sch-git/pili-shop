package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Description: 商品接口
 * @Author: chenghao.su
 * @Date: 2020/2/16 10:49
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Reference(timeout = 60000)
    CommodityBaseService commodityBaseService;
    @Autowired
    HttpSession session;

    /**
     * 添加商品
     *
     * @param addCommodityAO 商品对象
     * @return
     */
    @PostMapping("")
    public Result addCommodity(@RequestBody AddCommodityAO addCommodityAO) {
        addCommodityAO.setCreateId((Long) session.getAttribute(session.getId()));
        commodityBaseService.addCommodity(addCommodityAO);
        return new Result(ResultEnum.ADD_SUCCESS);
    }

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

    @PutMapping("/status")
    public Result updateCommodityStatus() {
        return Result.success();
    }
}
