package com.sch.adminservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.adminbase.VO.AdminVO;
import com.sch.adminbase.base.AdminBaseService;
import com.sch.adminbase.exception.AdminException;
import com.sch.adminservice.service.AdminService;
import com.sch.commonbasic.enums.AdminEnum;
import org.springframework.beans.factory.annotation.Autowired;

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
     * @return Admin
     */
    @Override
    public AdminVO find(String name) {
        if (name == null) {
            throw new AdminException(AdminEnum.EXCEPTION_NOT_NAME);
        }
        AdminVO adminVO = adminService.find(name);
        if (adminVO == null) {
            throw new AdminException(AdminEnum.EXCEPTION_NOT_NAME);
        }
        return adminVO;
    }
}
