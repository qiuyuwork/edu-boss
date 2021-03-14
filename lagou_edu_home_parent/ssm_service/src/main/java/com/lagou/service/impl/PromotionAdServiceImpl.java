package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.entity.PromotionAd;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper promotionAdMapper;

    /**
     * 广告分页查询
     * @return
     */
    @Override
    public PageInfo<PromotionAd> findAllByPage(int pageNum, int pageSize) {
        // 开启分页查询
        PageHelper.startPage(pageNum,pageSize);
        List<PromotionAd> allByPage = promotionAdMapper.findAllByPage();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allByPage);
        return pageInfo;
    }

    /**
     * 添加广告
     */
    @Override
    public void savePromotionAd(PromotionAd promotionAd){
        // 补全时间信息
        Date now = new Date();
        promotionAd.setCreateTime(now);
        promotionAd.setUpdateTime(now);
        // 创建广告
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    /**
     * 更新广告
     */
    @Override
    public void updatePromotionAd(PromotionAd promotionAd){
        // 更新时间
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    /**
     * 根据id获取广告信息
     */
    @Override
    public PromotionAd findPromotionAdById(int id) {
        return promotionAdMapper.findPromotionAdById(id);
    }

    @Override
    public void updatePromotionAdStatus(PromotionAd promotionAd) {
        // 更新时间
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
