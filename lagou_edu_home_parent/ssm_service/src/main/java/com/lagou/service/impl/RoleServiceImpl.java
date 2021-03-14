package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.dao.RoleMapper;
import com.lagou.entity.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色 条件：角色名称
     */
    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询所有菜单【树形结构】
     */
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findSubMenuListByPid(-1);
    }

    /**
     * 根据角色Id 查找关联菜单的Id
     */
    @Override
    public List<Integer> findMenuByRoleId(int roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    /**
     * 更新 角色-菜单 关系
     */
    @Override
    public void updateRoleMenuRelation(RoleMenuVo roleMenuVo) {
        // 清空 关系
        roleMapper.deleteRoleMenuRelations(roleMenuVo.getRoleId());
        // 重建 关系
        Role_menu_relation relation = new Role_menu_relation();
        relation.setRoleId(roleMenuVo.getRoleId());
        Date now = new Date();
        relation.setCreatedTime(now);
        relation.setUpdatedTime(now);
        relation.setCreatedBy("SYSTEM");
        relation.setUpdatedby("SYSTEM");
        for (Integer menuId : roleMenuVo.getMenuIdList()) {
            relation.setMenuId(menuId);
            roleMapper.buildRoleMenuRelation(relation);
        }
    }

    /**
     * 删除角色
     */
    @Override
    public void deleteRole(int id) {
        // 清除 角色-菜单 关系
        roleMapper.deleteRoleMenuRelations(id);
        // 删除 角色
        roleMapper.deleteRole(id);
    }

    /**
     * 添加角色
     * @param role
     */
    @Override
    public void saveRole(Role role) {
        // 补全信息
        role.setCreatedBy("SYSTEM");
        role.setUpdatedBy("SYSTEM");
        Date now = new Date();
        role.setCreatedTime(now);
        role.setUpdatedTime(now);
        // 保存
        roleMapper.saveRole(role);
    }

    /**
     * 修改角色
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        // 补全信息
        role.setUpdatedTime(new Date());
        role.setUpdatedBy("SYSTEM");
        // 更新
        roleMapper.updateRole(role);
    }

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    /**
     * 获取角色关联的资源信息与资源所属的分类信息
     */
    @Override
    public List<ResourceCategory> findResourceAndCategoryByRoleId(int roleId) {
        // 获取所有资源分类 列表
        List<ResourceCategory> resourceCategoryList = resourceCategoryMapper.findAllResourceCategory();
        // 获取角色关联的所有 资源
        List<Resource> resourceList = roleMapper.findResourceByRoleId(roleId);
        // 以资源Id为键构建Map
        Map<Integer,ResourceCategory> map = new HashMap<>();
        for (ResourceCategory resourceCategory : resourceCategoryList) {
            map.put(resourceCategory.getId(),resourceCategory);
        }
        // 将资源放入对应的分类
        for (Resource resource : resourceList) {
            // 获取所属分类
            ResourceCategory resourceCategory = map.get(resource.getCategoryId());
            if(resourceCategory.getResourceList()==null){
                resourceCategory.setResourceList(new ArrayList<>());
            }
            // 将资源放入分类的资源列表
            resourceCategory.getResourceList().add(resource);
        }
        // 去除没有资源的分类
        for (ResourceCategory resourceCategory : map.values()) {
            List<Resource> rl = resourceCategory.getResourceList();
            if(rl==null || rl.size()==0){
                resourceCategoryList.remove(resourceCategory);
            }
        }

        return resourceCategoryList;
    }

    /**
     * 更新角色所拥有的的资源
     */
    @Override
    public void updateRoleResource(RoleResourceVo roleResourceVo) {
        // 清空角色资源
        roleMapper.deleteRoleResource(roleResourceVo.getRoleId());
        // 为角色 重新绑定资源
        RoleResourceRelation rrr = new RoleResourceRelation();
        rrr.setRoleId(roleResourceVo.getRoleId());
        Date now = new Date();
        rrr.setCreatedTime(now);
        rrr.setUpdatedTime(now);
        rrr.setCreatedBy("SYSTEM");
        rrr.setUpdatedBy("SYSTEM");
        for (Integer resourceId : roleResourceVo.getResourceIdList()) {
            rrr.setResourceId(resourceId);
            roleMapper.addRoleResource(rrr);
        }
    }
}
