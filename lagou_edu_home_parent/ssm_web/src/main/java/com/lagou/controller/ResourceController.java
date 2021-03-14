package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.Resource;
import com.lagou.entity.ResourceVo;
import com.lagou.entity.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 多条件 分页 查询资源信息
     */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo){
        PageInfo<Resource> resources = resourceService.findAllResourceByPage(resourceVo);
        return new ResponseResult(resources);
    }

    /**
     * 添加或修改 资源信息
     */
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource){
        if(resource.getId()==null){
            // 创建资源 操作
            resourceService.saveResource(resource);
            return new ResponseResult("创建资源成功", null);
        }else{
            // 修改资源 操作
            resourceService.updateResource(resource);
            return new ResponseResult("修改资源成功", null);
        }
    }

    /**
     * 根据资源Id 删除资源
     */
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id){
        resourceService.deleteResource(id);
        return new ResponseResult("删除资源成功", null);
    }
}
