package com.sch.orderservice.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private Long id;

    private Long orderId;

    private Long commodityId;

    private String commodityName;

    private BigDecimal price;

    private Integer number;

    private String url;
}