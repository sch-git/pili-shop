package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.AO.RoleAO;
import com.sch.adminbase.VO.RoleVO;
import com.sch.adminbase.base.RoleBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 添加角色
     *
     * @param roleAO 角色信息
     */
    @PostMapping("/add")
    public Result addRole(@RequestBody RoleAO roleAO) {
        roleService.addRole(roleAO);
        return new Result(ResultEnum.ADD_SUCCESS);
    }

    /**
     * 删除角色
     *
     * @param roleId 角色id
     */
    @GetMapping("/delete")
    public Result deleteRole(@RequestParam Long roleId) {
        roleService.deleteRole(roleId);
        return new Result(ResultEnum.DELETE_SUCCESS);
    }
}
