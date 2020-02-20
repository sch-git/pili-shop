package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.userbase.AO.SearchUserAO;
import com.sch.userbase.AO.UpdateUserStatusAO;
import com.sch.userbase.VO.UserVO;
import com.sch.userbase.base.UserBaseService;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 用户模块后台接口
 * @Author: chenghao.su
 * @Date: 2020/2/3 22:28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户服务
     */
    @Reference(timeout = 60000)
    UserBaseService userBaseService;

    /**
     * 查询用户列表
     *
     * @param searchUserAO 查询条件
     */
    @GetMapping("/list")
    public Result findUserList(@ModelAttribute SearchUserAO searchUserAO) {
        PageInfo<UserVO> pageInfo = userBaseService.findUserList(searchUserAO);
        return Result.success(pageInfo);
    }

    /**
     * 修改用户状态
     *
     * @param updateUserStatusAO 修改用户状态条件
     * @return
     */
    @PutMapping("/status")
    public Result updateUserStatus(@RequestBody UpdateUserStatusAO updateUserStatusAO) {
        userBaseService.updateUserStatus(updateUserStatusAO);
        return new Result(ResultEnum.UPDATE_USER_STATUS);
    }
}
