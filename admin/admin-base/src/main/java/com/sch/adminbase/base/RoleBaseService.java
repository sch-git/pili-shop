package com.sch.adminbase.base;

import com.sch.adminbase.VO.RoleVO;

import java.util.List;

/**
 * @Description: 管理员模块外部接口--角色
 * @Author: chenghao.su
 * @Date: 2020/1/23 15:52
 */
public interface RoleBaseService {
    /**
     * 查询角色
     *
     * @param id 管理员id
     * @return List<RoleVO>
     */
    List<RoleVO> findRolesByAdminId(Long id);
}
