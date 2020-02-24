package com.sch.commoditybase.VO;

import com.sch.commonbasic.util.QiNiuCloudUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 商品图片VO
 * @Author: chenghao.su
 * @Date: 2020/2/24 17:52
 */
@Data
public class CommodityImageVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * 商品图片地址
     */
    private String url;

    public void setUrl(String url) {
        this.url = QiNiuCloudUtil.getDOMAIN() + url;
    }
}
