package com.sch.adminbase.base;

import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.AdminRoleAO;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.AO.RoleAO;
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

    /**
     * 查询角色
     *
     * @param url 请求地址
     * @return List<RoleVO>
     */
    List<RoleVO> findRolesByUrl(String url);

    /**
     * 查询角色
     *
     * @param pageAO 查询条件
     * @return 角色列表
     */
    PageInfo<RoleVO> findAll(PageAO pageAO);

    /**
     * 添加角色
     *
     * @param ao 角色信息
     */
    void addRole(RoleAO ao);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     */
    void deleteRole(long roleId);

    /**
     * 修改管理员角色
     *
     * @param adminRoleAO 管理员角色
     */
    void changeRole(AdminRoleAO adminRoleAO);
}
