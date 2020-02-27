package com.sch.commodityservice.base;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.commoditybase.AO.AddCommodityImageAO;
import com.sch.commoditybase.VO.CommodityImageVO;
import com.sch.commoditybase.base.CommodityImageBaseService;
import com.sch.commodityservice.service.CommodityImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 商品图片服务外部接口实现
 * @Author: chenghao.su
 * @Date: 2020/2/20 15:41
 */
@Service
public class CommodityImageBaseServiceImpl implements CommodityImageBaseService {
    @Autowired
    CommodityImageService commodityImageService;

    /**
     * 添加商品图片
     *
     * @param addCommodityImageAO 商品图片对象
     */
    @Override
    public void addCommodityImage(AddCommodityImageAO addCommodityImageAO) {
        commodityImageService.addCommodityImage(addCommodityImageAO);
    }

    /**
     * 根据商品id查询商品图片
     *
     * @param commodityId 商品id
     * @return 图片列表
     */
    @Override
    public List<CommodityImageVO> findImageByCommodityId(Long commodityId) {
        return commodityImageService.findImageByCommodityId(commodityId);
    }

    /**
     * 根据id删除图片
     *
     * @param id 图片id
     */
    @Override
    public void deleteImageById(Long id) {
        commodityImageService.deleteImageById(id);
    }
}
