package com.sch.adminservice.service;

import com.sch.adminbase.VO.ResourceVO;

import java.util.List;

/**
 * @Author: chenghao.su
 * @Date: 2020/5/2 21:24
 */
public interface ResourceService {
    /**
     * 查询权限
     *
     * @return 权限列表
     */
    List<ResourceVO> findAll();

    /**
     * 根据角色id查询权限
     *
     * @param id 角色id
     * @return 权限列表
     */
    List<ResourceVO> findResourceByRoleId(long id);
}
