package com.sch.userservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
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
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}