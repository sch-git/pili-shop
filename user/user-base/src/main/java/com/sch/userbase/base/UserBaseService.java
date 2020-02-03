package com.sch.userbase.base;

import com.github.pagehelper.PageInfo;
import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.VO.UserVO;

/**
 * @Description: 用户模块外部接口
 * @Author: chenghao.su
 * @Date: 2020/2/3 21:02
 */
public interface UserBaseService {
    /**
     * 查询用户列表
     *
     * @param searchUserAO 查询条件
     * @return 用户列表
     */
    PageInfo<UserVO> findUserList(SearchUserAO searchUserAO);
}
