package com.sch.adminservice.dao;

import com.sch.adminservice.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 角色
 * @Author: chenghao.su
 * @Date: 2020/1/23 15:28
 */
@Repository
public interface RoleDao {
    /********************************查询*****************************/
    /**
     * 查询角色
     *
     * @param id 管理员id
     * @return 角色集合
     */
    List<Role> findRolesByAdminId(Long id);

    /**
     * 查询角色
     *
     * @param url 请求路径
     * @return 角色集合
     */
    List<Role> findRolesByUrl(String url);
}