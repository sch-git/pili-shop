package com.sch.backweb.controller;

import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.VO.AdminVO;
import com.sch.adminbase.base.AdminBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.commonbasic.util.QiNiuCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 管理员接口
 * @Author: chenghao.su
 * @Date: 2020/1/13 19:40
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminBaseService adminService;

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
     * 查询所有管理员
     *
     * @param pageAO 查询条件
     * @return 管理员列表
     */
    @GetMapping("/list")
    public Result findAll(@ModelAttribute @Validated PageAO pageAO) {
        PageInfo<AdminVO> adminList = adminService.findAll(pageAO);
        return Result.success(adminList);
    }

    /**
     * 删除管理员
     *
     * @param id 管理员id
     */
    @DeleteMapping("/id")
    public Result deleteAdmin(@RequestParam Long id) {
        adminService.deleteAdmin(id);
        return new Result(ResultEnum.DELETE_SUCCESS);
    }
}
