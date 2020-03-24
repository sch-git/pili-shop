package com.sch.userservice;

import com.sch.userbase.base.AddressBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 用户地址模块Service测试
 * @Author: chenghao.su
 * @Date: 2020/2/3 22:20
 */
@SpringBootTest
public class AddressServiceTest {
    @Autowired
    AddressBaseService addressBaseService;

    /**
     * 查询用户地址列表
     */
    @Test
    void findAddressList() {
        System.out.println(addressBaseService.findAddressList(1L));
    }

}
