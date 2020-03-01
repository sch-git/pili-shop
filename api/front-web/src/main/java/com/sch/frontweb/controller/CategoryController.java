package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;
import com.sch.commoditybase.base.CategoryBaseService;
import com.sch.commonbasic.VO.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 前台-分类接口
 * @Author: chenghao.su
 * @Date: 2020/3/1 14:36
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    /**
     * 分类服务
     */
    @Reference(timeout = 60000)
    CategoryBaseService categoryBaseService;

    /**
     * 查询分类
     *
     * @param searchCategoryAO 查询对象
     * @return 分类对象列表
     */
    @GetMapping("/list")
    public Result findCategoryList(@ModelAttribute SearchCategoryAO searchCategoryAO) {
        PageInfo<CategoryVO> pageInfo = categoryBaseService.findCategoryList(searchCategoryAO);
        return Result.success(pageInfo);
    }
}
