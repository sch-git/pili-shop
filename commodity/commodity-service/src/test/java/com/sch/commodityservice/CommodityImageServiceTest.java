package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCommodityImageAO;
import com.sch.commodityservice.service.CommodityImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: service测试
 * @Author: chenghao.su
 * @Date: 2020/2/20 15:17
 */
@SpringBootTest
public class CommodityImageServiceTest {
    @Autowired
    CommodityImageService service;

    @Test
    public void addCommodityImage() {
        AddCommodityImageAO addCommodityImageAO = new AddCommodityImageAO();

        addCommodityImageAO.setCommodityId(1L);
        addCommodityImageAO.setCreateName("root");
        addCommodityImageAO.setCreateId(1L);
        addCommodityImageAO.setUrl("testUrl001");
        service.addCommodityImage(addCommodityImageAO);
    }
}
