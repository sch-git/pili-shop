package com.sch.adminbase.base;

import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.VO.ResourceVO;

/**
 * @Author: chenghao.su
 * @Date: 2020/5/2 21:26
 */
public interface ResourceBaseService {
    /**
     * 查询权限
     *
     * @param pageAO 查询条件
     * @return 权限列表
     */
    PageInfo<ResourceVO> findAll(PageAO pageAO);
}
