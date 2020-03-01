package com.sch.commoditybase.VO;

import com.sch.commonbasic.util.QiNiuCloudUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 商品VO
 * @Author: chenghao.su
 * @Date: 2020/2/22 10:37
 */
@Data
public class CommodityVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 前端分类名称
     */
    private String categoryName;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private Float price;

    /**
     * 商品描述
     */
    private String describe;

    /**
     * 商品状态：是否上架
     * 0：否;1：是
     */
    private Boolean status;

    /**
     * 商品默认图片地址
     */
    private String url;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人名称
     */
    private String updateName;

    /**
     * 修改时间
     */
    private String updateTime;

    public void setUrl(String url) {
        this.url = QiNiuCloudUtil.getDOMAIN() + url;
    }
}
