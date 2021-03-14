package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.PromotionAd;

/**
 * @author 默尘
 */
public interface PromotionAdService {
    /**
     * 广告分页查询
     * @return
     */
    PageInfo<PromotionAd> findAllByPage(int pageNum, int pageSize);

    /**
     * 添加广告
     */
    void savePromotionAd(PromotionAd promotionAd);

    /**
     * 更新广告
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 根据id获取广告信息
     */
    PromotionAd findPromotionAdById(int id);

    /**
     * 广告状态上下线
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);
}
