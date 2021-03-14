package com.lagou.dao;

import com.lagou.entity.Resource;
import com.lagou.entity.ResourceVo;

import java.util.List;

public interface ResourceMapper {
    /**
     * 多条件 查询 资源信息
     */
    List<Resource> findAllResource(ResourceVo resourceVo);

    /**
     * 添加 资源信息
     */
    int saveResource(Resource resource);

    /**
     * 修改 资源信息
     */
    int updateResource(Resource resource);

    /**
     * 根据资源id 删除资源信息
     */
    int deleteResource(int resourceId);
}
