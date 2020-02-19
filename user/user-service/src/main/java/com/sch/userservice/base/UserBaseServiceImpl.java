package com.sch.userservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.commonbasic.enums.UserEnum;
import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.AO.UpdateUserStatusAO;
import com.sch.userbase.VO.UserVO;
import com.sch.userbase.base.UserBaseService;
import com.sch.userbase.exception.UserException;
import com.sch.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpSession;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBaseServiceImpl.class);
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 查询用户列表
     *
     * @param searchUserAO 查询条件
     * @return 用户列表
     */
    @Override
    public PageInfo<UserVO> findUserList(SearchUserAO searchUserAO) {
        LOGGER.info("查询数据库:userService.findAll(searchUserAO);");
        Page page = PageHelper.startPage(searchUserAO.getPageNum(), searchUserAO.getPageSize());
        List<UserVO> userVOS = userService.findAll(searchUserAO);
        PageInfo<UserVO> pageInfo = new PageInfo<>(userVOS);
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPages(page.getPages());
        return pageInfo;
    }

    /**
     * 修改用户状态
     *
     * @param updateUserStatusAO 修改条件
     */
    @Override
    public void updateUserStatus(UpdateUserStatusAO updateUserStatusAO) {
        if (updateUserStatusAO.getStatus() == null) {
            throw new UserException(UserEnum.EXCEPTION_NOT_PARAM);
        }
        if (updateUserStatusAO.getId() == null) {
            throw new UserException(UserEnum.EXCEPTION_NOT_PARAM);
        }
        userService.updateUserStatus(updateUserStatusAO);
    }

    @Autowired
    HttpSession session;

    @Override
    public void test() {
        System.out.println(session.getAttribute(session.getId()));
    }
}
