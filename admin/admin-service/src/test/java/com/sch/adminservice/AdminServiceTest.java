package com.sch.adminservice;

import com.sch.adminservice.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 管理员服务测试
 * @Author: chenghao.su
 * @Date: 2020/1/21 18:32
 */
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    /**
     * 查询管理员
     */
    @Test
    public void find() {
        System.out.println(adminService.find("root"));
    }
}
