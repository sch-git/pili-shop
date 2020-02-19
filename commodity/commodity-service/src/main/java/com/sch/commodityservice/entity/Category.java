package com.sch.commodityservice.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 商品分类
 * @Author: chenghao.su
 * @Date: 2020/2/15 21:49
 */
@Data
public class Category {
    /**
     * 分类id
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 是否可用（0：否；1：是）
     */
    private Boolean status;
    /**
     * 创建人id
     */
    private Long createId;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人id
     */
    private Long updateId;
    /**
     * 修改人名称
     */
    private String updateName;
    /**
     * 修改时间
     */
    private Date updateTime;
}