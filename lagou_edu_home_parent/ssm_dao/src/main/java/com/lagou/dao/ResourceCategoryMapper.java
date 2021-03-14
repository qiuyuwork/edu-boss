package com.lagou.dao;

import com.lagou.entity.Resource;
import com.lagou.entity.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    /**
     * 获取资源分类列表，查找所有 资源分类 信息
     */
    List<ResourceCategory> findAllResourceCategory();

    /**
     * 添加 资源分类 信息
     */
    int saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 修改 资源分类信息
     */
    int updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据id 删除资源分类 信息
     */
    int deleteResourceCategory(int id);

    /**
     * 根据资源分类ID 查找属于该分类的资源
     */
    List<Resource> findResourceByCategoryId(int categoryId);
}
