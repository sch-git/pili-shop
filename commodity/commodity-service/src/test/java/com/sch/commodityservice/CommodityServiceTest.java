package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityStatusAO;
import com.sch.commoditybase.base.CommodityBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 商品服务测试
 * @Author: chenghao.su
 * @Date: 2020/2/14 18:52
 */
@SpringBootTest
public class CommodityServiceTest {
    @Autowired
    CommodityBaseService commodityBaseService;

    /**
     * 添加商品
     */
    @Test
    public void addCommodity() {
        AddCommodityAO addCommodityAO = new AddCommodityAO();
        addCommodityAO.setCategoryId(1L);
        addCommodityAO.setName("测试商品001");
        addCommodityAO.setStatus(true);
        addCommodityAO.setUrl("http://pili-shop.schblog.cn/testUrl001");
        addCommodityAO.setCreateName("root");
        addCommodityAO.setDescribe("测试描述001");
        addCommodityAO.setPrice(99.00f);
        System.out.println(commodityBaseService.addCommodity(addCommodityAO));
    }

    /**
     * 查询商品
     */
    @Test
    public void findAll() {
        SearchCommodityAO searchCommodityAO = new SearchCommodityAO();
        searchCommodityAO.setCategoryId(null);
        searchCommodityAO.setName("");
        searchCommodityAO.setPageNum(1);
        searchCommodityAO.setPageSize(3);
        searchCommodityAO.setStatus(null);
        System.out.println(commodityBaseService.findCommodityList(searchCommodityAO));
    }

    @Test
    public void updateCommodityStatus() {
        UpdateCommodityStatusAO ao = new UpdateCommodityStatusAO();
        ao.setId(1L);
        ao.setUpdateId(1L);
        ao.setStatus(false);
        ao.setUpdateName(null);
        commodityBaseService.updateCommodityStatus(ao);
    }
}
