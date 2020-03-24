package com.sch.userservice.service.impl;

import com.sch.commonbasic.util.DateUtil;
import com.sch.userbase.AO.AddressAO;
import com.sch.userbase.VO.AddressVO;
import com.sch.userservice.dao.AddressDao;
import com.sch.userservice.dto.AddAddressDTO;
import com.sch.userservice.entity.Address;
import com.sch.userservice.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户地址
 * @Author: chenghao.su
 * @Date: 2020/3/24 20:25
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    /**
     * 用户新增地址
     *
     * @param addressAO 新的地址
     */
    @Override
    @Transactional
    public void addAddress(AddressAO addressAO) {
        AddAddressDTO dto = new AddAddressDTO();
        BeanUtils.copyProperties(addressAO, dto);
        dto.setCreateTime(DateUtil.createTime());
        dto.setUpdateTime(DateUtil.createTime());
        addressDao.addAddress(dto);
    }

    /**
     * 查询用户地址列表
     *
     * @param userId 用户id
     * @return 地址列表
     */
    @Override
    public List<AddressVO> findAddressList(Long userId) {
        List<Address> addressList = addressDao.findAddressList(userId);
        if (addressList == null) {
            return null;
        }
        List<AddressVO> addressVOS = new ArrayList<>();
        for (Address address : addressList) {
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(address, addressVO);
            addressVO.setCreateTime(DateUtil.toString(address.getCreateTime()));
            addressVO.setUpdateTime(DateUtil.toString(address.getUpdateTime()));
            addressVOS.add(addressVO);
        }
        return addressVOS;
    }
}
