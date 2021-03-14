package com.lagou.controller;

import com.lagou.entity.PromotionSpace;
import com.lagou.entity.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    /**
     * 获取所有广告位
     * @return
     */
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> promotionSpaces = promotionSpaceService.findAllPromotionSpace();
        return new ResponseResult(promotionSpaces);
    }

    /**
     * 添加 或 修改 广告位
     * @param promotionSpace
     * @return
     */
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        if(promotionSpace.getId()==null){
            // 新增 广告位
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return new ResponseResult(true,200,"添加广告位成功",null);
        }else {
            // 修改 广告位
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            return new ResponseResult(true,200,"修改广告位成功",null);

        }
    }

    /**
     * 根据id 获取广告位信息【名称】
     * @param id
     * @return
     */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult ss(Integer id){
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return new ResponseResult("查询广告位信息成功",promotionSpace);
    }
}
