package com.sch.adminservice;

import com.sch.adminservice.dao.AdminDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 管理员dao服务测试
 * @Author: chenghao.su
 * @Date: 2020/1/21 18:32
 */
@SpringBootTest
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    /**
     * 查询管理员
     */
    @Test
    public void findByName() {
        System.out.println(adminDao.findByName("root"));
    }
}
