package com.sch.userservice;

import com.sch.userbase.AO.SearchUserAO;
import com.sch.userservice.dao.UserDao;
import com.sch.userservice.dto.UpdateUserStatusDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 用户模块Dao测试
 * @Author: chenghao.su
 * @Date: 2020/2/3 21:19
 */
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    /**
     * 查询所有用户
     */
    @Test
    void findAll() {
        SearchUserAO searchUserAO = new SearchUserAO();
        searchUserAO.setPageNum(1);
        searchUserAO.setPageSize(4);
        System.out.println(userDao.findAll(searchUserAO));
    }

    /**
     * 修改用户状态
     */
    @Test
    void updateUserStatus() {
        UpdateUserStatusDTO updateUserStatusDTO = new UpdateUserStatusDTO();
        updateUserStatusDTO.setId(2L);
        updateUserStatusDTO.setStatus(false);
        userDao.updateUserStatus(updateUserStatusDTO);
    }
}
