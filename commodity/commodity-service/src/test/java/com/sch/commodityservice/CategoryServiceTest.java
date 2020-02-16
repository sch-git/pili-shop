package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commoditybase.AO.SearchCategoryAO;
import com.sch.commoditybase.base.CategoryBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

/**
 * @Description: 商品分类DAO测试
 * @Author: chenghao.su
 * @Date: 2020/2/15 22:19
 */
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryBaseService service;
    @Autowired
    HttpSession session;

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
        searchCategoryAO.setName("");
        searchCategoryAO.setStatus(true);
        searchCategoryAO.setPageNum(1);
        searchCategoryAO.setPageSize(10);
        System.out.println(service.findCategoryList(searchCategoryAO));
    }
}
