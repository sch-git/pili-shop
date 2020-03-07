package com.sch.userbase.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: UserVO
 * @Author: chenghao.su
 * @Date: 2020/2/3 21:43
 */
@Data
public class UserVO implements Serializable {
    /**
     * 用户id
     */
    @JsonIgnore
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
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;
}
