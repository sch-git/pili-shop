package com.sch.adminservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.adminbase.VO.RoleVO;
import com.sch.adminbase.base.RoleBaseService;
import com.sch.adminbase.exception.AdminException;
import com.sch.adminservice.service.RoleService;
import com.sch.commonbasic.enums.AdminEnum;
import org.springframework.beans.factory.annotation.Autowired;

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
}
