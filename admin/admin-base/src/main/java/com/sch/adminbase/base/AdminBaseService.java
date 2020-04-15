package com.sch.adminbase.base;

import com.github.pagehelper.PageInfo;
import com.sch.adminbase.AO.PageAO;
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
    AdminVO findByName(String name);

    /**
     * 查询所有管理员
     *
     * @return 管理员列表
     */
    PageInfo<AdminVO> findAll(PageAO pageAO);

    /**
     * 删除管理员
     *
     * @param id 管理员id
     */
    void deleteAdmin(long id);
}
