package com.sch.adminservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Resource {
    /**
     * id
     */
    private Long id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限路径
     */
    private String url;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 父类权限id
     */
    private Long pid;

    /**
     * 权限等级
     */
    private Byte level;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}