package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.commom.Config;
import com.lagou.entity.PromotionAd;
import com.lagou.entity.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    /**
     * 分页查询广告信息
     */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(Integer currentPage,Integer pageSize){
        PageInfo<PromotionAd> allByPage = promotionAdService.findAllByPage(currentPage, pageSize);
        return new ResponseResult("分页查询成功",allByPage);
    }

    /**
     * 广告图片上传
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult PromotionAdUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        // 拼接图片存储目录
        File realPath = new File(request.getServletContext().getRealPath("/"));
        File imgStore = new File(realPath.getParent(), Config.IMGSTORE);
        if(!imgStore.exists()){
            imgStore.mkdirs();
        }
        // 新文件名
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        // 拷贝文件
        file.transferTo(new File(imgStore,fileName));
        // 返回信息
        Map<String,String> info = new HashMap<>();
        info.put("fileName",fileName);
        info.put("filePath",Config.DOMAIN+"/"+Config.IMGSTORE+"/"+fileName);

        return new ResponseResult(info);
    }

    /**
     * 创建或更新广告
     */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){
        if(promotionAd.getId()==null){
            // 创建
            promotionAdService.savePromotionAd(promotionAd);
            return new ResponseResult("广告创建成功",null);
        }else{
            // 更新
            promotionAdService.updatePromotionAd(promotionAd);
            return new ResponseResult("广告更新成功",null);
        }
    }

    /**
     * 根据id获取广告信息
     */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(int id){
        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        return new ResponseResult(promotionAd);
    }

    /**
     * 广告状态上下线
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(PromotionAd promotionAd){
        promotionAdService.updatePromotionAdStatus(promotionAd);
        Map<String,Object> info = new HashMap<>();
        info.put("status",promotionAd.getStatus());
        return new ResponseResult(info);
    }
}
