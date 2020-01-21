package com.sch.adminbase.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: AdminVO
 * @Author: chenghao.su
 * @Date: 2020/1/20 21:17
 */
@Data
public class AdminVO implements Serializable {
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
