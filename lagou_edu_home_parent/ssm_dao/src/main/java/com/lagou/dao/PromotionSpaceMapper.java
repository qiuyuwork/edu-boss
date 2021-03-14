package com.lagou.dao;

import com.lagou.entity.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {
    /**
     * 查询所有广告位
     * @return
     */
    List<PromotionSpace>  findAllPromotionSpace();

    /**
     * 新增广告位
     * @param promotionSpace
     * @return
     */
    int savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 修改 广告位
     * @param promotionSpace
     * @return
     */
    int updatePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 根据id 获取广告位信息【名称】
     */
    PromotionSpace findPromotionSpaceById(int id);

}
