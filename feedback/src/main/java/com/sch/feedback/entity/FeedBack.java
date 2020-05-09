package com.sch.feedback.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sch
 */
@Data
public class FeedBack implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 接收者id
     */
    private Long rid;

    /**
     * 发送者id
     */
    private Long sid;

    /**
     * 发送者名称
     */
    private String name;

    /**
     * 发送者头像
     */
    private String url;

    /**
     * 反馈标题
     */
    private String title;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createTime;
}