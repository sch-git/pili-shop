package com.sch.adminservice.service.impl;

import com.sch.adminbase.VO.ResourceVO;
import com.sch.adminservice.dao.ResourceDao;
import com.sch.adminservice.entity.Resource;
import com.sch.adminservice.service.ResourceService;
import com.sch.commonbasic.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenghao.su
 * @Date: 2020/5/2 21:37
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceDao resourceDao;

    /**
     * 查询权限
     *
     * @return 权限列表
     */
    @Override
    public List<ResourceVO> findAll() {
        List<Resource> resources = resourceDao.findAll();
        List<ResourceVO> vos = new ArrayList<>(resources.size());
        for (Resource resource : resources) {
            ResourceVO vo = new ResourceVO();
            BeanUtils.copyProperties(resource, vo);
            vo.setCreateTime(DateUtil.toString(resource.getCreateTime()));
            vo.setUpdateTime(DateUtil.toString(resource.getUpdateTime()));
            vos.add(vo);
        }
        return vos;
    }
}
