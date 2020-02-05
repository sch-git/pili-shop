package com.sch.userbase.AO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 修改用户状态条件
 * @Author: chenghao.su
 * @Date: 2020/2/5 16:30
 */
@Data
public class UpdateUserStatusAO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 状态
     */
    private Boolean status;
}
