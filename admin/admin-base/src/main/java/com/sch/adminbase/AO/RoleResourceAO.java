package com.sch.adminbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Title: 角色权限
 * @Description: 角色权限
 * @Author: chenghao.su
 * @Date: 2020/5/25 22:53
 */
@Data
public class RoleResourceAO implements Serializable {
    /**
     * 角色id
     */
    @NotNull
    private long roleId;

    /**
     * 权限
     */
    private List<ResourceAO> resourceAOS;
}
