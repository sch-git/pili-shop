package com.sch.adminservice.service;

import com.sch.adminbase.VO.AdminVO;

import java.util.List;

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

    /**
     * 查询所有管理员
     *
     * @return 管理员列表
     */
    List<AdminVO> findAll();

    /**
     * 删除管理员
     *
     * @param id 管理员id
     */
    void deleteAdmin(long id);
}

