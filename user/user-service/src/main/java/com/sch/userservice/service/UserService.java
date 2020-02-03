package com.sch.userservice.service;

import com.sch.userbase.AO.SearchUserAO;
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
}
