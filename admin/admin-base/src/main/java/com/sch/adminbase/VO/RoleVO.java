package com.sch.adminbase.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: RoleVO
 * @Author: chenghao.su
 * @Date: 2020/1/23 16:17
 */
@Data
public class RoleVO implements Serializable {
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
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;
}
