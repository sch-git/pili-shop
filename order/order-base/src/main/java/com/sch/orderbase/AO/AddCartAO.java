package com.sch.orderbase.AO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 添加购物车AO
 * @Author: chenghao.su
 * @Date: 2020/3/7 16:54
 */
@Data
public class AddCartAO implements Serializable {

    private Long commodityId;

    private String commodityName;

    private BigDecimal price;

    private Integer number;

    private String url;
}
