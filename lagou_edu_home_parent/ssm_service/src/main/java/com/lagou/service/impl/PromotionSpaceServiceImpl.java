package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.entity.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    /**
     * 查询所有广告位
     * @return
     */
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    /**
     * 添加广告位
     * @param promotionSpace
     */
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        // 补全信息
        Date now = new Date();
        promotionSpace.setCreateTime(now);
        promotionSpace.setUpdateTime(now);
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        promotionSpace.setIsDel(0);
        // 添加广告位
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    /**
     * 修改广告位
     * @param promotionSpace
     */
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        // 补全信息
        Date now = new Date();
        promotionSpace.setUpdateTime(now);
        // 添加广告位
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }

    /**
     * 根据id 获取广告位信息【名称】
     * @param id
     * @return
     */
    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }
}
