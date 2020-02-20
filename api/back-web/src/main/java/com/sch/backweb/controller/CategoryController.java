package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;
import com.sch.commoditybase.base.CategoryBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Description: 分类接口
 * @Author: chenghao.su
 * @Date: 2020/2/16 10:50
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    HttpSession session;
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

    /**
     * 修改分类
     *
     * @param updateCategoryAO 实体对象
     * @return 修改结果
     */
    @PutMapping("/item")
    public Result updateCategory(@RequestBody UpdateCategoryAO updateCategoryAO) {
        updateCategoryAO.setUpdateId((Long) session.getAttribute(session.getId()));
        categoryBaseService.updateCategory(updateCategoryAO);
        return new Result(ResultEnum.UPDATE_SUCCESS);
    }

    /**
     * 新增分类
     *
     * @param addCategoryAO 新增分类对象
     * @return 新增结果
     */
    @PostMapping("")
    public Result addCategory(@RequestBody AddCategoryAO addCategoryAO) {
        addCategoryAO.setCreateId((Long) session.getAttribute(session.getId()));
        categoryBaseService.addCategory(addCategoryAO);
        return new Result(ResultEnum.ADD_SUCCESS);
    }
}
