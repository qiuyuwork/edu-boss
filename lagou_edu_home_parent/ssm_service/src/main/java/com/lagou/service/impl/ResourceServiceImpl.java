package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.entity.Resource;
import com.lagou.entity.ResourceVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 多条件 分页 查询资源信息
     */
    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo) {
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());

        List<Resource> resources = resourceMapper.findAllResource(resourceVo);

        return new PageInfo<>(resources);
    }


    /**
     * 添加 资源信息
     */
    @Override
    public void saveResource(Resource resource) {
        // 补全时间及创建者信息
        Date now = new Date();
        resource.setCreatedTime(now);
        resource.setUpdatedTime(now);
        resource.setCreatedBy("SYSTEM");
        resource.setUpdatedBy("SYSTEM");
        // 添加
        resourceMapper.saveResource(resource);
    }

    /**
     * 修改 资源信息
     */
    @Override
    public void updateResource(Resource resource) {
        // 补全更新时间及操作人
        resource.setUpdatedTime(new Date());
        resource.setUpdatedBy("SYSTEM");
        // 更新
        resourceMapper.updateResource(resource);
    }

    /**
     * 根据资源id 删除资源信息
     */
    @Override
    public void deleteResource(int resourceId) {
        resourceMapper.deleteResource(resourceId);
    }
}
