package com.sch.adminbase.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: chenghao.su
 * @Date: 2020/5/2 21:20
 */
@Data
public class ResourceVO implements Serializable {
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
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;
}
