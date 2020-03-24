package com.sch.userbase.base;

import com.sch.userbase.AO.AddressAO;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 20:30
 */
public interface AddressBaseService {
    /**
     * 用户新增地址
     *
     * @param addressAO 新的地址
     */
    void addAddress(AddressAO addressAO);
}
