package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.VO.RoleVO;
import com.sch.adminbase.base.RoleBaseService;
import com.sch.commonbasic.VO.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: 角色控制器
 * @Author: chenghao.su
 * @Date: 2020/5/9 18:07
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Reference
    RoleBaseService roleService;

    /**
     * 查询角色
     *
     * @param pageAO 查询条件
     * @return 角色列表
     */
    @GetMapping("/list")
    public Result findRoleList(@ModelAttribute PageAO pageAO) {
        PageInfo<RoleVO> roleVos = roleService.findAll(pageAO);
        return Result.success(roleVos);
    }
}
