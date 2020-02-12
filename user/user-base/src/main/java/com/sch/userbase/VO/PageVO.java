package com.sch.userbase.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: redis缓存Page
 * @Author: chenghao.su
 * @Date: 2020/2/12 13:25
 */
@Data
public class PageVO implements Serializable {
    /**
     * 总数据
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
}
