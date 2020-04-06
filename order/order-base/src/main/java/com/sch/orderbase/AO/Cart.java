package com.sch.orderbase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品名
     */
    @NotBlank
    private String name;
    /**
     * 商品价格
     */
    @NotNull
    private BigDecimal price;
    /**
     * 商品数量
     */
    @NotNull
    private Integer number;
    /**
     * 商品图片
     */
    @NotBlank
    private String url;
}
