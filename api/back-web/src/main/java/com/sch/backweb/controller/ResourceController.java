package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.AO.ResourceAO;
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
}
