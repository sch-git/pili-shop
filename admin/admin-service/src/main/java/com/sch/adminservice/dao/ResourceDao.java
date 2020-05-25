package com.sch.adminservice.dao;

import com.sch.adminbase.AO.ResourceAO;
import com.sch.adminservice.entity.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceDao {
    /**
     * 查询权限
     *
     * @return 权限列表
     */
    List<Resource> findAll();

    /**
     * 根据角色id查询权限
     *
     * @param id 角色id
     * @return 权限列表
     */
    List<Resource> findResourceByRoleId(long id);

    /**
     * 删除权限
     *
     * @param id 权限id
     */
    void deleteById(long id);

    /**
     * 添加权限
     *
     * @param ao 权限信息
     */
    void addResource(ResourceAO ao);

    /**
     * 删除角色权限
     *
     * @param id 角色id
     */
    void deleteByRoleId(long id);
}