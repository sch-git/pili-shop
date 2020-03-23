package com.sch.userservice.dao;

import com.sch.userbase.AO.SearchUserAO;
import com.sch.userservice.dto.UpdateUserDTO;
import com.sch.userservice.dto.UpdateUserStatusDTO;
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

    /**
     * 修改用户状态
     *
     * @param updateUserStatusDTO 修改条件
     */
    void updateUserStatus(UpdateUserStatusDTO updateUserStatusDTO);

    /**
     * 根据用户名查询对象
     *
     * @param name 用户名
     * @return user对象
     */
    User findUserByName(String name);

    /**
     * 修改用户信息
     *
     * @param updateUserDTO 新用户信息
     */
    void updateUser(UpdateUserDTO updateUserDTO);
}