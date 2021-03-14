package com.lagou.service;

import com.lagou.entity.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {
    /**
     * 获取资源分类列表，查找所有 资源分类 信息
     */
    List<ResourceCategory> findAllResourceCategory();

    /**
     * 添加 资源分类 信息
     */
    void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 修改 资源分类信息
     */
    void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据id 删除资源分类 信息
     */
    void deleteResourceCategory(int id);

    /**
     * 根据 是否有资源 关联此分类，判断能否删除
     */
    boolean canDeleteCategory(int categoryId);

}
