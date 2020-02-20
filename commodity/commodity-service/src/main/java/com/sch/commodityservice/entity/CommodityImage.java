package com.sch.commodityservice.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 商品图片
 * @Author: chenghao.su
 * @Date: 2020/2/20 14:38
 */
@Data
public class CommodityImage {
    /**
     * id
     */
    private Long id;

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * 商品图片地址
     */
    private String url;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;
}