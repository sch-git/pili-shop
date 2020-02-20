package com.sch.commodityservice.service;

import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;

import java.util.List;

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

    /**
     * 通过实体作为筛选条件查询
     *
     * @param searchCategoryAO 实体对象
     * @return 分类集合
     */
    List<CategoryVO> findAll(SearchCategoryAO searchCategoryAO);

    /**
     * 修改数据
     *
     * @param updateCategoryAO 实例对象
     */
    void updateCategory(UpdateCategoryAO updateCategoryAO);
}