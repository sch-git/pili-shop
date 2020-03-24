package com.sch.userbase.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 19:25
 */
@Data
public class AddressVO implements Serializable {
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
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;
}
