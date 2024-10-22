package com.sch.orderbase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
     * 订单编号
     */
    private String code;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 总价
     */
    @NotNull
    private BigDecimal total;
    /**
     * 用户名
     */
    @NotBlank
    private String userName;
    /**
     * 收货人
     */
    @NotBlank
    private String receiveName;
    /**
     * 手机号
     */
    @NotBlank
    private String phone;
    /**
     * 省份
     */
    @NotBlank
    private String province;
    /**
     * 城市
     */
    @NotBlank
    private String city;
    /**
     * 区域
     */
    @NotBlank
    private String district;
    /**
     * 详细地址
     */
    @NotBlank
    private String detailedAddress;
    /**
     * 订单商品数据
     */
    @NotNull
    private List<Cart> cartList;
}
