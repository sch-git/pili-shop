package com.sch.orderbase.AO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 订单数据
 * @Author: chenghao.su
 * @Date: 2020/3/27 15:10
 */
@Data
public class OrderAO implements Serializable {
    /**
     * 总价
     */
    private BigDecimal total;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 收货人
     */
    private String receiveName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区域
     */
    private String district;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 订单商品数据
     */
    private List<Cart> cartList;
}
