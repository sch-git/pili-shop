package com.sch.adminservice.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 管理员
 * @Author: chenghao.su
 * @Date: 2020/1/20 20:28
 */
@Data
public class Admin {
    /**
     * id
     */
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}