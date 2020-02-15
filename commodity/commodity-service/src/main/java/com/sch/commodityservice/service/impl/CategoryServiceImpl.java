package com.sch.commodityservice.service.impl;

import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.exception.CommodityException;
import com.sch.commodityservice.dao.CategoryDao;
import com.sch.commodityservice.dto.AddCategoryDTO;
import com.sch.commodityservice.service.CategoryService;
import com.sch.commonbasic.enums.CommodityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
}
