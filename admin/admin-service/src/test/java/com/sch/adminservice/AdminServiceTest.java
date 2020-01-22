package com.sch.adminservice;

import com.sch.adminservice.service.AdminService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceTest.class);

    /**
     * 查询管理员
     */
    @Test
    public void find() {
        System.out.println(adminService.find("root"));
    }

    /**
     * 测试日志
     */
    @Test
    public void log() {
        LOGGER.trace("trace");
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
    }
}
