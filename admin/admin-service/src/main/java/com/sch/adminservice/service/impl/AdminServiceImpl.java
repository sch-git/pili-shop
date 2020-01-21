package com.sch.adminservice.service.impl;

import com.sch.adminbase.VO.AdminVO;
import com.sch.adminservice.dao.AdminDao;
import com.sch.adminservice.entity.Admin;
import com.sch.adminservice.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: chenghao.su
 * @Date: 2020/1/13 20:44
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public AdminVO find(String name) {
        Admin admin = adminDao.find(name);
        if (admin == null) {
            return null;
        }
        AdminVO adminVO = new AdminVO();
        BeanUtils.copyProperties(admin, adminVO);
        return adminVO;
    }
}
