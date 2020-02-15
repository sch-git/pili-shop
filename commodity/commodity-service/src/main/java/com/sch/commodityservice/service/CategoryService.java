package com.sch.commodityservice.service;

import com.sch.commoditybase.AO.AddCategoryAO;

/**
 * @Description: 商品分类服务
 * @Author: chenghao.su
 * @Date: 2020/2/15 21:49
 */
public interface CategoryService {

    /**
     * 新增分类
     *
     * @param addCategoryAO 分类对象
     */
    void addCategory(AddCategoryAO addCategoryAO);
}