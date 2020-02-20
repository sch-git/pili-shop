package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
