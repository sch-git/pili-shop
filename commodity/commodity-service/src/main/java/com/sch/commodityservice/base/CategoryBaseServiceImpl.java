package com.sch.commodityservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;
import com.sch.commoditybase.base.CategoryBaseService;
import com.sch.commoditybase.exception.CommodityException;
import com.sch.commodityservice.service.CategoryService;
import com.sch.commonbasic.enums.CommodityEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 分类模块外部接口实现
 * @Author: chenghao.su
 * @Date: 2020/2/16 09:45
 */
@Service
public class CategoryBaseServiceImpl implements CategoryBaseService {
    @Autowired
    CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param addCategoryAO 分类对象
     */
    @Override
    public void addCategory(AddCategoryAO addCategoryAO) {
        categoryService.addCategory(addCategoryAO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param searchCategoryAO 实体对象
     * @return 分类列表
     */
    @Override
    public PageInfo<CategoryVO> findCategoryList(SearchCategoryAO searchCategoryAO) {
        Page page = PageHelper.startPage(searchCategoryAO.getPageNum(), searchCategoryAO.getPageSize());
        List<CategoryVO> categoryVOS = categoryService.findAll(searchCategoryAO);
        PageInfo<CategoryVO> pageInfo = new PageInfo<>(categoryVOS);
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPages(page.getPages());
        return pageInfo;
    }

    /**
     * 修改数据
     *
     * @param updateCategoryAO 修改分类对象
     */
    @Override
    public void updateCategory(UpdateCategoryAO updateCategoryAO) {
        if (updateCategoryAO.getName() == null || updateCategoryAO.getName().isEmpty()) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_CATEGORYNAME);
        }
        if (updateCategoryAO.getStatus() == null) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_STATUS);
        }
        categoryService.updateCategory(updateCategoryAO);
    }
}
