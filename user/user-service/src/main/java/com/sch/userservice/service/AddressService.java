package com.sch.userservice.service;

import com.sch.userbase.AO.AddressAO;
import com.sch.userbase.VO.AddressVO;

import java.util.List;

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
     * @return 新增的地址id
     */
    Long addAddress(AddressAO addressAO);

    /**
     * 查询用户地址列表
     *
     * @param userId 用户id
     * @return 地址列表
     */
    List<AddressVO> findAddressList(Long userId);

    /**
     * 查询用户地址
     *
     * @param id 地址id
     * @return 地址信息
     */
    AddressVO findAddressById(Long id);

    /**
     * 用户删除地址
     *
     * @param id 被删除的地址id
     */
    void deleteAddressById(Long id);

    /**
     * 用户修改地址
     *
     * @param addressAO 修改后的地址信息
     */
    void updateAddressById(AddressAO addressAO);
}
