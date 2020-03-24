package com.sch.userservice.service.impl;

import com.sch.commonbasic.util.DateUtil;
import com.sch.userbase.AO.AddressAO;
import com.sch.userservice.dao.AddressDao;
import com.sch.userservice.dto.AddAddressDTO;
import com.sch.userservice.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
