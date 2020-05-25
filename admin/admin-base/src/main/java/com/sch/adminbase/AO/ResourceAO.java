package com.sch.adminbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Title: 权限AO
 * @Author: chenghao.su
 * @Date: 2020/5/3 17:29
 */
@Data
public class ResourceAO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 权限名
     */
    @NotNull
    private String name;

    /**
     * 权限路径
     */
    @NotNull
    private String url;

    /**
     * 权限编码
     */
    @NotNull
    private String code;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建时间
     */
    private String updateTime;

}
