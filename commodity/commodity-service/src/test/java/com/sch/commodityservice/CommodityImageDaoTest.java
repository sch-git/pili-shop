package com.sch.commodityservice;

import com.sch.commodityservice.dao.CommodityImageDao;
import com.sch.commodityservice.entity.CommodityImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description: dao测试
 * @Author: chenghao.su
 * @Date: 2020/2/20 15:17
 */
@SpringBootTest
public class CommodityImageDaoTest {
    @Autowired
    CommodityImageDao commodityImageDao;

    @Test
    public void findImageByCommodityId() {
        List<CommodityImage> list = commodityImageDao.findImageByCommodityId(2L);
        for (CommodityImage image : list) {
            System.out.println(image);
        }
    }
}
