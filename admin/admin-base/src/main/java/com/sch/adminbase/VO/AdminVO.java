package com.sch.adminbase.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

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
    @JsonIgnore
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    @JsonIgnore
    private String phone;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;
}
