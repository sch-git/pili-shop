package com.sch.adminservice.service;

import com.sch.adminbase.VO.RoleVO;

import java.util.List;

/**
 * @Description: Role
 * @Author: chenghao.su
 * @Date: 2020/1/23 16:21
 */
public interface RoleService {
    /**
     * 查询角色
     *
     * @param id 管理员id
     * @return List<RoleVO>
     */
    List<RoleVO> findRolesByAdminId(Long id);

    /**
     * 查询角色
     *
     * @param url 请求地址
     * @return List<RoleVO>
     */
    List<RoleVO> findRolesByUrl(String url);
}
