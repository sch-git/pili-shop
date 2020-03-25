package com.sch.userservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.userbase.AO.AddressAO;
import com.sch.userbase.VO.AddressVO;
import com.sch.userbase.base.AddressBaseService;
import com.sch.userservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 20:30
 */
@Service
public class AddressBaseServiceImpl implements AddressBaseService {
    @Autowired
    AddressService addressService;

    /**
     * 用户新增地址
     *
     * @param addressAO 新的地址
     * @return 新增的地址id
     */
    @Override
    public Long addAddress(AddressAO addressAO) {
        return addressService.addAddress(addressAO);
    }

    /**
     * 查询用户地址列表
     *
     * @param userId 用户id
     * @return 地址列表
     */
    @Override
    public List<AddressVO> findAddressList(Long userId) {
        return addressService.findAddressList(userId);
    }

    /**
     * 查询用户地址
     *
     * @param id 地址id
     * @return 地址信息
     */
    @Override
    public AddressVO findAddressById(Long id) {
        return addressService.findAddressById(id);
    }

    /**
     * 用户删除地址
     *
     * @param id 被删除的地址id
     */
    @Override
    public void deleteAddressById(Long id) {
        addressService.deleteAddressById(id);
    }

    /**
     * 用户修改地址
     *
     * @param addressAO 修改后的地址信息
     */
    @Override
    public void updateAddressById(AddressAO addressAO) {
        addressService.updateAddressById(addressAO);
    }

}
