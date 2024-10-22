package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityAO;
import com.sch.commoditybase.AO.UpdateCommodityStatusAO;
import com.sch.commoditybase.VO.CommodityDetailVO;
import com.sch.commoditybase.VO.CommodityVO;
import com.sch.commoditybase.base.CommodityBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        addCommodityAO.setPrice(new BigDecimal("99.00"));
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
        searchCommodityAO.setPageSize(6);
        searchCommodityAO.setStatus(true);
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

    /**
     * 修改商品信息
     */
    @Test
    public void updateCommodity() {
        UpdateCommodityAO updateCommodityAO = new UpdateCommodityAO();
        updateCommodityAO.setId(1L);
        updateCommodityAO.setCategoryId(1L);
        updateCommodityAO.setName("");
        updateCommodityAO.setPrice(new BigDecimal("99.00"));
        updateCommodityAO.setDescribe("测试描述001");
        updateCommodityAO.setStatus(true);
        updateCommodityAO.setUpdateId(1L);
        updateCommodityAO.setUpdateName("root");
        commodityBaseService.updateCommodity(updateCommodityAO);
    }

    /**
     * 根据商品id查询详情
     */
    @Test
    public void findById() {
        List<CommodityDetailVO> commodityDetailVOS = commodityBaseService.findById(1L);
        for (CommodityDetailVO vo : commodityDetailVOS) {
            System.out.println(vo);
        }
    }

    /**
     * 查询购物车数据
     */
    @Test
    public void findByIds() {
        Set<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        List<CommodityVO> commodityVOS = commodityBaseService.findByIds(strings);
        for (CommodityVO commodityVO : commodityVOS) {
            System.out.println(commodityVO);
        }
    }
}
