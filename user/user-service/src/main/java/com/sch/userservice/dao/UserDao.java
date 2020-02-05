package com.sch.userservice.dao;

import com.sch.userbase.AO.SearchUserAO;
import com.sch.userservice.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 用户
 * @Author: chenghao.su
 * @Date: 2020/2/3 20:39
 */
@Repository
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @param searchUserAO 查询条件
     * @return 用户列表
     */
    List<User> findAll(SearchUserAO searchUserAO);
}