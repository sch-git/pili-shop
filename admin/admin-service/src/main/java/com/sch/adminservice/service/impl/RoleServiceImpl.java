package com.sch.adminservice.service.impl;

import com.sch.adminbase.VO.RoleVO;
import com.sch.adminservice.dao.RoleDao;
import com.sch.adminservice.entity.Role;
import com.sch.adminservice.service.RoleService;
import com.sch.commonbasic.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Role服务实现
 * @Author: chenghao.su
 * @Date: 2020/1/23 16:21
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * 查询角色
     *
     * @param id 管理员id
     * @return List<RoleVO>
     */
    @Override
    public List<RoleVO> findRolesByAdminId(Long id) {
        List<Role> roles = roleDao.findRolesByAdminId(id);
        if (roles != null) {
            List<RoleVO> roleVOS = new ArrayList<>();
            for (Role role : roles) {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(role, roleVO);
                roleVO.setCreateTime(DateUtil.toString(role.getCreateTime()));
                roleVO.setUpdateTime(DateUtil.toString(role.getUpdateTime()));
                roleVOS.add(roleVO);
            }
            return roleVOS;
        }
        return null;
    }

    /**
     * 查询角色
     *
     * @param url 请求地址
     * @return List<RoleVO>
     */
    @Override
    public List<RoleVO> findRolesByUrl(String url) {
        List<Role> roles = roleDao.findRolesByUrl(url);
        if (roles.size() > 0) {
            List<RoleVO> roleVOS = new ArrayList<>();
            for (Role role : roles) {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(role, roleVO);
                roleVOS.add(roleVO);
            }
            return roleVOS;
        }
        return null;
    }
}
