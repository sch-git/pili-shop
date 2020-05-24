package com.sch.adminservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.AO.RoleAO;
import com.sch.adminbase.VO.RoleVO;
import com.sch.adminbase.base.RoleBaseService;
import com.sch.adminbase.exception.AdminException;
import com.sch.adminservice.dao.RoleDao;
import com.sch.adminservice.service.RoleService;
import com.sch.commonbasic.enums.AdminEnum;
import com.sch.commonbasic.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 供外部调用的Role服务RPC接口
 * @Author: chenghao.su
 * @Date: 2020/1/23 16:18
 */
@Service
public class RoleBaseServiceImpl implements RoleBaseService {

    /**
     * Role服务
     */
    @Autowired
    private RoleService roleService;
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
        if (id == null) {
            throw new AdminException(AdminEnum.EXCEPTION_NOT_PARAM);
        }
        List<RoleVO> roleVOS = roleService.findRolesByAdminId(id);

        return roleVOS;
    }

    /**
     * 查询角色
     *
     * @param url 请求地址
     * @return List<RoleVO>
     */
    @Override
    public List<RoleVO> findRolesByUrl(String url) {
        if (url == null) {
            throw new AdminException(AdminEnum.EXCEPTION_NOT_PARAM);
        }
        List<RoleVO> roleVOS = roleService.findRolesByUrl(url);
        return roleVOS;
    }

    /**
     * 查询角色
     *
     * @param pageAO 查询条件
     * @return 角色列表
     */
    @Override
    public PageInfo<RoleVO> findAll(PageAO pageAO) {
        Page page = PageHelper.startPage(pageAO.getPageNum(), pageAO.getPageSize());
        List<RoleVO> roleVOS = roleDao.findAll();
        PageInfo<RoleVO> pageInfo = new PageInfo<>(roleVOS);
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
     * 添加角色
     *
     * @param ao 角色信息
     */
    @Override
    @Transactional
    public void addRole(RoleAO ao) {
        ao.setCreateTime(DateUtil.createTime());
        roleDao.addRole(ao);
    }
}
