package com.sch.userservice.service;

import com.sch.userbase.AO.AddressAO;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 20:24
 */
public interface AddressService {
    /**
     * 用户新增地址
     *
     * @param addressAO 新的地址
     */
    void addAddress(AddressAO addressAO);
}
