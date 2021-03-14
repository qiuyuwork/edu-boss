package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.Resource;
import com.lagou.entity.ResourceVo;

public interface ResourceService {
    /**
     * 多条件 分页 查询资源信息
     */
    PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo);


    /**
     * 添加 资源信息
     */
    void saveResource(Resource resource);

    /**
     * 修改 资源信息
     */
    void updateResource(Resource resource);

    /**
     * 根据资源id 删除资源信息
     */
    void deleteResource(int resourceId);

}
