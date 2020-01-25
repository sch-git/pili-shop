package com.sch.adminservice;

import com.sch.adminservice.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: Role服务测试
 * @Author: chenghao.su
 * @Date: 2020/1/23 19:55
 */
@SpringBootTest
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;

    /**
     * 查询角色
     */
    @Test
    public void findRoleBYAdminId() {
        System.out.println(roleService.findRolesByAdminId(1L));
    }

    /**
     * 查询角色
     */
    @Test
    public void findRolesByUrl() {
        System.out.println(roleService.findRolesByUrl("/admin"));
    }
}
