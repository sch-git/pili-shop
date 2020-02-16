package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;
import com.sch.commoditybase.base.CategoryBaseService;
import com.sch.commonbasic.VO.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 分类接口
 * @Author: chenghao.su
 * @Date: 2020/2/16 10:50
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

    @PutMapping("/item")
    public Result updateCategory(@RequestBody UpdateCategoryAO updateCategoryAO) {
        return Result.success();
    }

    @PostMapping("")
    public Result addCategory(@RequestBody AddCategoryAO addCategoryAO) {
        categoryBaseService.addCategory(addCategoryAO);
        return Result.success();
    }
}
