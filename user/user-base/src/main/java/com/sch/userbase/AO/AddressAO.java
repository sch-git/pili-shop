package com.sch.userbase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 19:24
 */
@Data
public class AddressAO implements Serializable {
    /**
     * 修改地址时需要，新增时不用
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
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
}
