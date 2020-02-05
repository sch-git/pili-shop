package com.sch.userservice.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户
 * @Author: chenghao.su
 * @Date: 2020/2/3 20:39
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 积分
     */
    private Integer points;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}