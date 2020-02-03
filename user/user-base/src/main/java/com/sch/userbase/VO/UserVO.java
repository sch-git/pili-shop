package com.sch.userbase.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

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
