package com.lagou.service.impl;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.entity.Resource;
import com.lagou.entity.ResourceCategory;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    /**
     * 获取资源分类列表，查找所有 资源分类 信息
     */
    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }

    /**
     * 添加 资源分类 信息
     */
    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        // 补全时间及创建人
        Date now = new Date();
        resourceCategory.setCreatedTime(now);
        resourceCategory.setUpdatedTime(now);
        resourceCategory.setCreatedBy("SYSTEM");
        resourceCategory.setUpdatedBy("SYSTEM");
        // 保存数据
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    /**
     * 修改 资源分类信息
     */
    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {
        // 补全时间及更新人
        resourceCategory.setUpdatedTime(new Date());
        resourceCategory.setUpdatedBy("SYSTEM");
        // 保存更新
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    /**
     * 根据id 删除资源分类 信息
     */
    @Override
    public void deleteResourceCategory(int id) {
        resourceCategoryMapper.deleteResourceCategory(id);
    }

    /**
     * 根据 是否有资源 关联此分类，判断能否删除
     */
    @Override
    public boolean canDeleteCategory(int categoryId) {
        List<Resource> resource = resourceCategoryMapper.findResourceByCategoryId(categoryId);
        if(resource.size()!=0) {
            return false;
        }
        return true;
    }
}
