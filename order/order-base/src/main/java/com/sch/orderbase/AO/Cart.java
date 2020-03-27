package com.sch.orderbase.AO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 提交订单时的商品数据
 * @Author: chenghao.su
 * @Date: 2020/3/27 15:14
 */
@Data
public class Cart implements Serializable {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private Integer number;
    /**
     * 商品描述
     */
    private String describe;
    /**
     * 商品图片
     */
    private String url;
}
