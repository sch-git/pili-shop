package com.sch.commoditybase.base;

import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;

/**
 * @Description: 分类模块外部接口
 * @Author: chenghao.su
 * @Date: 2020/2/16 09:44
 */
public interface CategoryBaseService {
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
     * @return 分类列表
     */
    PageInfo<CategoryVO> findCategoryList(SearchCategoryAO searchCategoryAO);

    /**
     * 修改数据
     *
     * @param updateCategoryAO 修改分类对象
     */
    void updateCategory(UpdateCategoryAO updateCategoryAO);
}
