package com.lagou.dao;

import com.lagou.entity.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {
    /**
     * 广告分页查询
     */
    List<PromotionAd> findAllByPage();


    /**
     * 添加广告
     */
    int savePromotionAd(PromotionAd promotionAd);

    /**
     * 更新广告
     */
    int updatePromotionAd(PromotionAd promotionAd);

    /**
     * 根据id获取广告信息
     */
    PromotionAd findPromotionAdById(int id);

    /**
     * 广告状态上下线
     */
    int updatePromotionAdStatus(PromotionAd promotionAd);
}
