package com.sch.adminservice;

import com.sch.adminservice.dao.RoleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 角色dao服务测试
 * @Author: chenghao.su
 * @Date: 2020/1/23 19:51
 */
@SpringBootTest
public class RoleDaoTest {
    @Autowired
    private RoleDao roleDao;

    /**
     * 查询角色
     */
    @Test
    public void findRoleBYAdminId() {
        System.out.println(roleDao.findRolesByAdminId(1L));
    }

    /**
     * 查询角色
     */
    @Test
    public void findRolesByUrl() {
        System.out.println(roleDao.findRolesByUrl("/admin"));
    }
}
