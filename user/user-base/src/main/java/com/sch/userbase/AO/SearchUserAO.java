package com.sch.userbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
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
    private Integer sex;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 当前页
     */
    @NotNull
    private Integer pageNum;

    /**
     * 每页记录数
     */
    @NotNull
    private Integer pageSize;
}
