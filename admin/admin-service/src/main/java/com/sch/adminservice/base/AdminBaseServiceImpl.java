package com.sch.adminservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
import com.sch.adminbase.VO.AdminVO;
import com.sch.adminbase.base.AdminBaseService;
import com.sch.adminbase.exception.AdminException;
import com.sch.adminservice.service.AdminService;
import com.sch.commonbasic.enums.AdminEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 供外部调用的Admin服务RPC接口
 * @Author: chenghao.su
 * @Date: 2020/1/20 20:28
 */
@Service
public class AdminBaseServiceImpl implements AdminBaseService {
    /**
     * 管理员服务
     */
    @Autowired
    AdminService adminService;

    /**
     * 查询管理员
     *
     * @param name 管理员账号
     * @return Admin 管理员
     */
    @Override
    public AdminVO findByName(String name) {
        if (name == null) {
            throw new AdminException(AdminEnum.EXCEPTION_NOT_NAME);
        }
        AdminVO adminVO = adminService.findByName(name);
        if (adminVO == null) {
            throw new AdminException(AdminEnum.EXCEPTION_NOT_NAME);
        }
        return adminVO;
    }

    /**
     * 查询所有管理员
     *
     * @return 管理员列表
     */
    @Override
    public PageInfo<AdminVO> findAll(PageAO pageAO) {
        Page page = PageHelper.startPage(pageAO.getPageNum(), pageAO.getPageSize());
        List<AdminVO> adminVOS = adminService.findAll();
        PageInfo<AdminVO> pageInfo = new PageInfo<>(adminVOS);
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
     * 删除管理员
     *
     * @param id 管理员id
     */
    @Override
    public void deleteAdmin(long id) {
        adminService.deleteAdmin(id);
    }
}
