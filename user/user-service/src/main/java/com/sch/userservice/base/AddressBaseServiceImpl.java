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
     */
    @Override
    public void addAddress(AddressAO addressAO) {
        addressService.addAddress(addressAO);
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
}
