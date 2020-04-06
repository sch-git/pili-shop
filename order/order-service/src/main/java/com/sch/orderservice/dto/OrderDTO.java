package com.sch.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: 订单
 * @Author: chenghao.su
 * @Date: 2020/3/29 17:51
 */
@Data
public class OrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 状态
     */
    private Byte status;
    /**
     * 总价
     */
    private BigDecimal total;
    /**
     * 用户id
     */
    private Long userId;
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
     * 创建时间
     */
    private String createTime;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 完成时间
     */
    private String successTime;
    /**
     * 取消时间
     */
    private String cancelTime;
}
