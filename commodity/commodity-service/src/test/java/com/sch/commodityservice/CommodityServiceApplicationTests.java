package com.sch.commodityservice;

import com.sch.commonbasic.util.QiNiuCloudUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommodityServiceApplicationTests {

    @Test
    void contextLoads() {
        String url = "http://pili-shop.schblog.cn/testUrl001";
        String[] re = url.split(QiNiuCloudUtil.getDOMAIN());
        System.out.println(re[1]);
    }

}
