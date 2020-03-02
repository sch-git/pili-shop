package com.sch.userservice.service.impl;

import com.sch.commonbasic.util.DateUtil;
import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.AO.UpdateUserStatusAO;
import com.sch.userbase.VO.UserVO;
import com.sch.userservice.dao.UserDao;
import com.sch.userservice.dto.UpdateUserStatusDTO;
import com.sch.userservice.entity.User;
import com.sch.userservice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户服务实现类
 * @Author: chenghao.su
 * @Date: 2020/2/3 20:40
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 用户数据层接口
     */
    @Autowired
    UserDao userDao;

    /**
     * 通过实体作为筛选条件查询
     *
     * @param searchUserAO 实体对象
     * @return 用户列表
     */
    @Override
    public List<UserVO> findAll(SearchUserAO searchUserAO) {
        List<User> users = userDao.findAll(searchUserAO);
        if (users == null) {
            return null;
        }
        List<UserVO> userVOS = new ArrayList<>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            userVO.setCreateTime(DateUtil.toString(user.getCreateTime()));
            userVO.setUpdateTime(DateUtil.toString(user.getUpdateTime()));
            userVOS.add(userVO);
        }
        return userVOS;
    }

    /**
     * 修改用户状态
     *
     * @param updateUserStatusAO 修改条件
     */
    @Override
    @Transactional
    public void updateUserStatus(UpdateUserStatusAO updateUserStatusAO) {
        UpdateUserStatusDTO updateUserStatusDTO = new UpdateUserStatusDTO();
        updateUserStatusDTO.setAO(updateUserStatusAO);
        userDao.updateUserStatus(updateUserStatusDTO);
    }

    /**
     * 根据用户名查询对象
     *
     * @param name 用户名
     * @return user对象
     */
    @Override
    public UserVO findUserByName(String name) {
        User user = userDao.findUserByName(name);
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setUpdateTime(DateUtil.toString(user.getUpdateTime()));
        userVO.setCreateTime(DateUtil.toString(user.getCreateTime()));
        return userVO;
    }
}
