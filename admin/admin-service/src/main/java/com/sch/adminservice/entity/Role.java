package com.sch.adminservice.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 角色
 * @Author: chenghao.su
 * @Date: 2020/1/23 15:28
 */
@Data
public class Role {
    /**
     * id
     */
    private Long id;

    /**
     * 角色名:管理员
     */
    private String name;

    /**
     * 角色标识ROLE_XXX
     */
    private String code;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}