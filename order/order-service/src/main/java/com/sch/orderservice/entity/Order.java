package com.sch.orderservice.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
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
    private String receiverName;
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
    private Date createTime;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 完成时间
     */
    private Date successTime;
    /**
     * 取消时间
     */
    private Date cancelTime;
}