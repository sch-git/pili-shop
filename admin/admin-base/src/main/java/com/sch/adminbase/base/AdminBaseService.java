package com.sch.adminbase.base;

import com.sch.adminbase.VO.AdminVO;

/**
 * @Description: 管理员模块外部接口
 * @Author: chenghao.su
 * @Date: 2020/1/20 18:56
 */
public interface AdminBaseService {
    /**
     * 查询管理员
     *
     * @param name 管理员账号
     * @return Admin
     */
    AdminVO find(String name);
}
