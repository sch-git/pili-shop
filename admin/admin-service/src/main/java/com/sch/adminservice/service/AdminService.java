package com.sch.adminservice.service;

import com.sch.adminbase.VO.AdminVO;

/**
 * @Description: 管理员
 * @Author: chenghao.su
 * @Date: 2020/1/13 20:43
 */
public interface AdminService {
    /**
     * 查询管理员
     *
     * @param name 管理员账号
     * @return Admin
     */
    AdminVO findByName(String name);
}

