package com.sch.userservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.VO.UserVO;
import com.sch.userbase.base.UserBaseService;
import com.sch.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 用户模块外部接口实现
 * @Author: chenghao.su
 * @Date: 2020/2/3 21:03
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {
    @Autowired
    UserService userService;

    /**
     * 查询用户列表
     *
     * @param searchUserAO 查询条件
     * @return 用户列表
     */
    @Override
    public PageInfo<UserVO> findUserList(SearchUserAO searchUserAO) {
        Page page = PageHelper.startPage(searchUserAO.getPageNum(), searchUserAO.getPageSize());
        List<UserVO> userVOS = userService.findAll(searchUserAO);
        PageInfo<UserVO> pageInfo = new PageInfo<>(userVOS);
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPages(page.getPages());
        return pageInfo;
    }
}
