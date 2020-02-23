package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commoditybase.base.CategoryBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 商品分类DAO测试
 * @Author: chenghao.su
 * @Date: 2020/2/15 22:19
 */
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryBaseService service;

    /**
     * 新增分类
     */
    @Test
    public void addCategory() {
        AddCategoryAO addCategoryAO = new AddCategoryAO();
        addCategoryAO.setCreateName("root");
        addCategoryAO.setName("公仔");
        addCategoryAO.setStatus(true);
    }

    /**
     * 查询分类
     */
    @Test
    public void findAll() {
        SearchCategoryAO searchCategoryAO = new SearchCategoryAO();
        searchCategoryAO.setPageNum(1);
        searchCategoryAO.setPageSize(0);
        System.out.println(service.findCategoryList(searchCategoryAO));
    }

    @Test
    public void updateCategory() {
        UpdateCategoryAO updateCategoryAO = new UpdateCategoryAO();
        updateCategoryAO.setId(1L);
        updateCategoryAO.setStatus(true);
        updateCategoryAO.setName("公仔");
        updateCategoryAO.setUpdateId(1L);
        updateCategoryAO.setUpdateName("root");
        service.updateCategory(updateCategoryAO);
    }
}
