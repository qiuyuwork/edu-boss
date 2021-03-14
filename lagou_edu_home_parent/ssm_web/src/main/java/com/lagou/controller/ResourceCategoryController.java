package com.lagou.controller;

import com.lagou.entity.ResourceCategory;
import com.lagou.entity.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /**
     * 获取 资源分类信息 列表
     */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(allResourceCategory);
    }

    /**
     * 添加或修改资源分类
     */
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory){
        if(resourceCategory.getId()==null){
            // 创建资源分类操作
            resourceCategoryService.saveResourceCategory(resourceCategory);
            return new ResponseResult("创建资源分类成功", null);
        }else{
            // 修改资源分类操作
            resourceCategoryService.updateResourceCategory(resourceCategory);
            return new ResponseResult("修改资源分类信息成功", null);
        }
    }

    /**
     * 根据id 删除资源分类 信息
     */
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id){
        // 判断是否有资源关联
        if(resourceCategoryService.canDeleteCategory(id)) {
            // 删除资源分类
            resourceCategoryService.deleteResourceCategory(id);
            return new ResponseResult("删除资源成功", null);
        }else{
            return new ResponseResult("删除失败，有资源与此分类关联",null);
        }
    }

}
