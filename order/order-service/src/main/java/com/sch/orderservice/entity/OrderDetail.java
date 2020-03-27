package com.sch.orderservice.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    /**
     * 详情
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 商品单价
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private Integer number;
    /**
     * 商品图片
     */
    private String url;
}