package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.*;
import com.sch.commoditybase.VO.CommodityImageVO;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import com.sch.commoditybase.base.CommodityImageBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Reference(timeout = 60000)
    CommodityImageBaseService commodityImageBaseService;
    @Autowired
    HttpSession session;

    /**
     * 添加商品
     *
     * @param addCommodityAO 商品对象
     * @return
     */
    @PostMapping("")
    public Result addCommodity(@RequestBody @Validated AddCommodityAO addCommodityAO) {
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

    /**
     * 修改商品状态
     *
     * @param updateCommodityStatusAO 修改条件
     * @return
     */
    @PutMapping("/status")
    public Result updateCommodityStatus(@RequestBody @Validated UpdateCommodityStatusAO updateCommodityStatusAO) {
        updateCommodityStatusAO.setUpdateId((Long) session.getAttribute(session.getId()));
        commodityBaseService.updateCommodityStatus(updateCommodityStatusAO);
        return new Result(ResultEnum.UPDATE_SUCCESS);
    }

    /**
     * 修改商品信息
     *
     * @param updateCommodityAO 修改条件
     * @return
     */
    @PutMapping("/item")
    public Result updateCommodity(@RequestBody @Validated UpdateCommodityAO updateCommodityAO) {
        updateCommodityAO.setUpdateId((Long) session.getAttribute(session.getId()));
        commodityBaseService.updateCommodity(updateCommodityAO);
        return new Result(ResultEnum.UPDATE_SUCCESS);
    }

    /**
     * 根据商品id查询图片
     *
     * @param commodityId 商品id
     * @return 图片列表
     */
    @GetMapping("/image")
    public Result findImageByCommodityId(@RequestParam Long commodityId) {
        List<CommodityImageVO> commodityImageVOS = commodityImageBaseService.findImageByCommodityId(commodityId);
        return Result.success(commodityImageVOS);
    }

    /**
     * 添加商品图片
     *
     * @param addCommodityImageAO 图片信息
     * @return
     */
    @PostMapping("/image")
    public Result addCommodityImage(@RequestBody AddCommodityImageAO addCommodityImageAO) {
        addCommodityImageAO.setCreateId((Long) session.getAttribute(session.getId()));
        commodityImageBaseService.addCommodityImage(addCommodityImageAO);
        return Result.success();
    }

    /**
     * 删除商品图片
     *
     * @param id 图片id
     * @return
     */
    @DeleteMapping("/image")
    public Result deleteCommodityImage(@RequestParam Long id) {
        System.out.println(id);
        commodityImageBaseService.deleteImageById(id);
        return new Result(ResultEnum.DELETE_SUCCESS);
    }
}
