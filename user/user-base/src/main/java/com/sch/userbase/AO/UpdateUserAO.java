package com.sch.userbase.AO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户修改信息
 * @Author: chenghao.su
 * @Date: 2020/3/23 16:39
 */
@Data
public class UpdateUserAO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Boolean sex;
}
