package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.AO.ResourceAO;
import com.sch.adminbase.AO.RoleResourceAO;
import com.sch.adminbase.VO.ResourceVO;
import com.sch.adminbase.base.ResourceBaseService;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 权限管理
 * @Author: chenghao.su
 * @Date: 2020/5/2 21:18
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Reference
    ResourceBaseService service;

    /**
     * 查询权限
     *
     * @param pageAO 查询条件
     * @return 权限列表
     */
    @GetMapping("/list")
    public Result findResourceList(@ModelAttribute PageAO pageAO) {
        PageInfo<ResourceVO> pageInfo = service.findAll(pageAO);
        return Result.success(pageInfo);
    }

    /**
     * 添加权限
     *
     * @param resourceAO 权限信息
     */
    @PostMapping("/add")
    public Result addResource(@Validated @RequestBody ResourceAO resourceAO) {
        service.addResource(resourceAO);
        return new Result(ResultEnum.UPDATE_SUCCESS);
    }

    /**
     * 删除权限
     *
     * @param id 权限id
     */
    @DeleteMapping("/delete")
    public Result deleteResource(@RequestParam Long id) {
        service.deleteById(id);
        return new Result(ResultEnum.DELETE_SUCCESS);
    }

    /**
     * 根据角色id查询权限
     *
     * @param id 角色id
     * @return 权限列表
     */
    @GetMapping("/roleId")
    public Result findResourceByRoleId(@RequestParam Long id) {
        PageInfo<ResourceVO> list = service.findResourceByRoleId(id);
        return Result.success(list);
    }

    /**
     * 修改角色权限
     *
     * @param ao 角色权限
     */
    @PostMapping("/change")
    public Result updateRoleResource(@RequestBody RoleResourceAO ao) {
        service.deleteByRoleId(ao.getRoleId());
        service.addRoleResource(ao);
        return Result.success(ResultEnum.UPDATE_SUCCESS);
    }
}
