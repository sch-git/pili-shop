package com.sch.adminbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Title: 管理员角色
 * @Description: 管理员角色
 * @Author: chenghao.su
 * @Date: 2020/5/26 17:57
 */
@Data
public class AdminRoleAO implements Serializable {
    /**
     * 管理员具有的角色id
     */
    @NotNull
    List<Long> roleIds;

    /**
     * 创建时间
     */
    String createTime;

    /**
     * 账号
     */
    String username;

    /**
     * 名称
     */
    String name;

    /**
     * 管理员id
     */
    @NotNull
    private Long adminId;
}
