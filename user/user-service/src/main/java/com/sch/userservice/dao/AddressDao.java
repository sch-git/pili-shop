package com.sch.userservice.dao;

import com.sch.userservice.dto.AddAddressDTO;
import com.sch.userservice.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {
    /**
     * 用户新增地址
     *
     * @param addAddressDTO 新地址
     */
    void addAddress(AddAddressDTO addAddressDTO);

    /**
     * 查询用户地址列表
     *
     * @param userId 用户id
     * @return 地址列表
     */
    List<Address> findAddressList(Long userId);
}