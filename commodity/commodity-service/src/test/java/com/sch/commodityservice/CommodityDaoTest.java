package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commodityservice.dao.CommodityDao;
import com.sch.commodityservice.dto.AddCommodityDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 商品DAO测试
 * @Author: chenghao.su
 * @Date: 2020/2/14 18:49
 */
@SpringBootTest
public class CommodityDaoTest {
    @Autowired
    CommodityDao commodityDao;

    /**
     * 添加商品
     */
    @Test
    public void addCommodity() {
        AddCommodityAO addCommodityAO = new AddCommodityAO();
        addCommodityAO.setCategoryId(1L);
        addCommodityAO.setName("测试商品001");
        addCommodityAO.setStatus(true);
        addCommodityAO.setUrl("root");
        addCommodityAO.setCreateName("root");
        addCommodityAO.setDescribe("测试描述001");
        addCommodityAO.setPrice(99.00f);
        AddCommodityDTO addCommodityDTO = new AddCommodityDTO();
        addCommodityDTO.setAO(addCommodityAO);
        addCommodityDTO.setCreateId(1L);
        commodityDao.addCommodity(addCommodityDTO);
        System.out.println(addCommodityDTO.getId());
    }
}
