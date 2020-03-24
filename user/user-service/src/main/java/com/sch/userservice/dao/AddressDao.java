package com.sch.userservice.dao;

import com.sch.userservice.dto.AddAddressDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao {
    /**
     * 用户新增地址
     *
     * @param addAddressDTO 新地址
     */
    void addAddress(AddAddressDTO addAddressDTO);
}