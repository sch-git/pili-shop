package com.sch.userservice;

import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.AO.UpdateUserStatusAO;
import com.sch.userbase.base.UserBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 用户模块Service测试
 * @Author: chenghao.su
 * @Date: 2020/2/3 22:20
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserBaseService userBaseService;

    /**
     * 查询用户列表
     */
    @Test
    void findUserList() {
        SearchUserAO searchUserAO = new SearchUserAO();
        searchUserAO.setPageNum(1);
        searchUserAO.setPageSize(10);
        System.out.println(userBaseService.findUserList(searchUserAO));
    }

    /**
     * 修改用户状态
     */
    @Test
    void updateUserStatus() {
        UpdateUserStatusAO updateUserStatusAO = new UpdateUserStatusAO();
        updateUserStatusAO.setId(2L);
        updateUserStatusAO.setStatus(true);
        userBaseService.updateUserStatus(updateUserStatusAO);
    }
}
