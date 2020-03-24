package com.sch.userbase.base;

import com.sch.userbase.AO.AddressAO;
import com.sch.userbase.VO.AddressVO;

import java.util.List;

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

    /**
     * 查询用户地址列表
     *
     * @param userId 用户id
     * @return 地址列表
     */
    List<AddressVO> findAddressList(Long userId);
}
