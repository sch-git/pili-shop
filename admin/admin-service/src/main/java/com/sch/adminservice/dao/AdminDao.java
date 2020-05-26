package com.sch.adminservice.dao;

import com.sch.adminservice.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 管理员
 * @Author: chenghao.su
 * @Date: 2020/1/20 20:28
 */
@Repository
public interface AdminDao {

    /********************************查询*****************************/
    /**
     * 查询管理员
     *
     * @param username 管理员账号
     * @return Admin
     */
    Admin findByName(String username);

    /**
     * 查询所有管理员
     *
     * @return 管理员列表
     */
    List<Admin> findAll();

    /**
     * 删除管理员
     *
     * @param id 管理员id
     */
    void deleteAdmin(long id);
}