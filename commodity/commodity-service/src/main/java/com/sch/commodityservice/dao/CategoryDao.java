package com.sch.commodityservice.dao;

import com.sch.commodityservice.dto.AddCategoryDTO;
import com.sch.commodityservice.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 商品分类
 * @Author: chenghao.su
 * @Date: 2020/2/15 21:49
 */
@Repository
public interface CategoryDao {

    /**
     * 通过实体作为筛选条件查询 TODO
     *
     * @param category 实例对象
     * @return 对象列表
     */
    List<Category> queryAll(Category category);

    /**
     * 新增分类
     *
     * @param category 分类对象
     */
    void addCategory(AddCategoryDTO category);

    /**
     * 修改数据 TODO
     *
     * @param category 实例对象
     * @return 影响行数
     */
    int update(Category category);

}