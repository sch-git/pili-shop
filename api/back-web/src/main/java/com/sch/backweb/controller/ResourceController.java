package com.sch.backweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.VO.ResourceVO;
import com.sch.adminbase.base.ResourceBaseService;
import com.sch.commonbasic.VO.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
