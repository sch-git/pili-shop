package com.sch.userbase.AO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 查询条件
 * @Author: chenghao.su
 * @Date: 2020/2/3 21:50
 */
@Data
public class SearchUserAO implements Serializable {
    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页记录数
     */
    private Integer pageSize;
}
