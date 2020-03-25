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

    /**
     * 查询用户地址
     *
     * @param id 地址id
     * @return 地址信息
     */
    Address findAddressById(Long id);

    /**
     * 用户删除地址
     *
     * @param id 被删除的地址id
     */
    void deleteAddressById(Long id);

    /**
     * 用户修改地址
     *
     * @param addAddressDTO 修改后的地址信息
     */
    void updateAddressById(AddAddressDTO addAddressDTO);
}