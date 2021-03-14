package com.lagou.service;

import com.lagou.entity.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {
    /**
     * 查询所有公告位
     * @return
     */
    List<PromotionSpace> findAllPromotionSpace();

    /**
     * 添加广告位
     * @param promotionSpace
     */
    void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 修改广告位
     * @param promotionSpace
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 根据id 获取广告位信息【名称】
     */
    PromotionSpace findPromotionSpaceById(int id);


}
