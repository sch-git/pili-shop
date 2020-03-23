package com.sch.userservice.service;

import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.AO.UpdateUserAO;
import com.sch.userbase.AO.UpdateUserStatusAO;
import com.sch.userbase.VO.UserVO;

import java.util.List;

/**
 * @Description: 用户服务接口
 * @Author: chenghao.su
 * @Date: 2020/2/3 20:39
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @param searchUserAO 查询条件
     * @return 用户列表
     */
    List<UserVO> findAll(SearchUserAO searchUserAO);

    /**
     * 修改用户状态
     *
     * @param updateUserStatusAO 修改条件
     */
    void updateUserStatus(UpdateUserStatusAO updateUserStatusAO);

    /**
     * 根据用户名查询对象
     *
     * @param name 用户名
     * @return user对象
     */
    UserVO findUserByName(String name);

    /**
     * 修改用户信息
     *
     * @param updateUserAO 新的用户信息
     */
    void updateUser(UpdateUserAO updateUserAO);
}
