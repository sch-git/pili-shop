package com.sch.adminservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.AO.ResourceAO;
import com.sch.adminbase.VO.ResourceVO;
import com.sch.adminbase.base.ResourceBaseService;
import com.sch.adminservice.dao.ResourceDao;
import com.sch.adminservice.service.ResourceService;
import com.sch.commonbasic.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: chenghao.su
 * @Date: 2020/5/2 21:27
 */
@Service
public class ResourceBaseServiceImpl implements ResourceBaseService {
    @Autowired
    ResourceService service;
    @Autowired
    ResourceDao dao;

    /**
     * 查询权限
     *
     * @param pageAO 查询条件
     * @return 权限列表
     */
    @Override
    public PageInfo<ResourceVO> findAll(PageAO pageAO) {
        Page page = PageHelper.startPage(pageAO.getPageNum(), pageAO.getPageSize());
        List<ResourceVO> resources = service.findAll();
        PageInfo<ResourceVO> pageInfo = new PageInfo<>(resources);
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
     * 添加权限
     *
     * @param ao 权限信息
     */
    @Override
    public void addResource(ResourceAO ao) {
        ao.setCreateTime(DateUtil.createTime());
        ao.setUpdateTime(DateUtil.createTime());
        dao.addResource(ao);
    }

    /**
     * 删除权限
     *
     * @param id 权限id
     */
    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}