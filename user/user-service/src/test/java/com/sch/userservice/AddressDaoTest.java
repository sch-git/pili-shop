package com.sch.userservice;

import com.sch.userservice.dao.AddressDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 用户地址模块Dao测试
 * @Author: chenghao.su
 * @Date: 2020/2/3 21:19
 */
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    AddressDao addressDao;

    /**
     * 查询所有用户
     */
    @Test
    void findAddressList() {
        System.out.println(addressDao.findAddressList(1L));
    }
}
