package com.sch.commodityservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 商品服务
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
@SpringBootApplication
@MapperScan("com.sch.commodityservice.dao")
@EnableDubbo
public class CommodityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommodityServiceApplication.class, args);
    }

}
