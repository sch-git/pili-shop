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
     * @return 新增的地址id
     */
    @Override
    @Transactional
    public Long addAddress(AddressAO addressAO) {
        AddAddressDTO dto = new AddAddressDTO();
        BeanUtils.copyProperties(addressAO, dto);
        dto.setCreateTime(DateUtil.createTime());
        dto.setUpdateTime(DateUtil.createTime());
        addressDao.addAddress(dto);
        return dto.getId();
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

    /**
     * 查询用户地址
     *
     * @param id 地址id
     * @return 地址信息
     */
    @Override
    public AddressVO findAddressById(Long id) {
        Address address = addressDao.findAddressById(id);
        if (address == null) {
            return null;
        }
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(address, addressVO);
        addressVO.setCreateTime(DateUtil.toString(address.getCreateTime()));
        addressVO.setUpdateTime(DateUtil.toString(address.getUpdateTime()));
        return addressVO;
    }

    /**
     * 用户删除地址
     *
     * @param id 被删除的地址id
     */
    @Override
    public void deleteAddressById(Long id) {
        addressDao.deleteAddressById(id);
    }

    /**
     * 用户修改地址
     *
     * @param addressAO 修改后的地址信息
     */
    @Override
    @Transactional
    public void updateAddressById(AddressAO addressAO) {
        AddAddressDTO dto = new AddAddressDTO();
        BeanUtils.copyProperties(addressAO, dto);
        dto.setUpdateTime(DateUtil.createTime());
        addressDao.updateAddressById(dto);
    }
}
