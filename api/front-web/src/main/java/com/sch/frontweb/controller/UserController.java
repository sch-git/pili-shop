package com.sch.frontweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.commonbasic.util.QiNiuCloudUtil;
import com.sch.userbase.AO.UpdateUserAO;
import com.sch.userbase.base.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 用户
 * @Author: chenghao.su
 * @Date: 2020/3/23 14:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Reference
    UserBaseService userBaseService;

    /**
     * 上传头像
     *
     * @param file 文件数据
     * @return 头像地址
     */
    @PostMapping("/avatar")
    public Result uploadAvatar(@RequestParam MultipartFile file) {
        String path = QiNiuCloudUtil.uploadImg(file);
        return new Result(ResultEnum.UPLOAD_IMAGE, path);
    }

    /**
     * 修改用户信息
     *
     * @param updateUserAO 新的用户信息
     * @return
     */
    @PutMapping("/update")
    public Result updateUser(@RequestBody UpdateUserAO updateUserAO) {
        Long userId = (Long) session.getAttribute(request.getHeader("Authorization"));
        updateUserAO.setId(userId);
        userBaseService.updateUser(updateUserAO);
        return Result.success();
    }
}