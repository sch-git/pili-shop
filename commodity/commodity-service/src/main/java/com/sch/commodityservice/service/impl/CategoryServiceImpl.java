package com.sch.commodityservice.service.impl;

import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.VO.CategoryVO;
import com.sch.commoditybase.exception.CommodityException;
import com.sch.commodityservice.dao.CategoryDao;
import com.sch.commodityservice.dto.AddCategoryDTO;
import com.sch.commodityservice.entity.Category;
import com.sch.commodityservice.service.CategoryService;
import com.sch.commonbasic.enums.CommodityEnum;
import com.sch.commonbasic.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 商品分类服务实现
 * @Author: chenghao.su
 * @Date: 2020/2/15 22:12
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    HttpSession session;

    /**
     * 新增分类
     *
     * @param addCategoryAO 分类对象
     */
    @Transactional
    @Override
    public void addCategory(AddCategoryAO addCategoryAO) {
        long userId;
        try {
            userId = (long) session.getAttribute(session.getId());
        } catch (NullPointerException npe) {
            throw new CommodityException(CommodityEnum.EXCEPTION_NULL_CREATEID);
        }
        AddCategoryDTO addCategoryDTO = new AddCategoryDTO();
        addCategoryDTO.setAO(addCategoryAO);
        addCategoryDTO.setCreateId(userId);
        categoryDao.addCategory(addCategoryDTO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param searchCategoryAO 实体对象
     * @return 分类集合
     */
    @Override
    public List<CategoryVO> findAll(SearchCategoryAO searchCategoryAO) {
        List<Category> categories = categoryDao.findAll(searchCategoryAO);
        if (categories == null) {
            return null;
        }
        List<CategoryVO> categoryVOS = new ArrayList<>();
        for (Category category : categories) {
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(category, categoryVO);
            categoryVO.setCreateTime(DateUtil.toString(category.getCreateTime()));
            categoryVO.setUpdateTime(DateUtil.toString(category.getUpdateTime()));
            categoryVOS.add(categoryVO);
        }
        return categoryVOS;
    }
}
