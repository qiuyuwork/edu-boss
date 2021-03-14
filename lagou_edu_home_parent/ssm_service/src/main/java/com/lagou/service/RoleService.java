package com.lagou.service;

import com.lagou.entity.*;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**
     * 查询所有角色 条件：角色名称
     */
    List<Role> findAllRole(Role role);

    /**
     * 查询所有菜单【树形结构】
     */
    List<Menu> findAllMenu();

    /**
     * 根据角色Id 查找关联菜单的Id
     */
    List<Integer> findMenuByRoleId(int roleId);

    /**
     * 更新 角色-菜单 关系
     */
    void updateRoleMenuRelation(RoleMenuVo roleMenuVo);

    /**
     * 删除角色
     */
    void deleteRole(int id);

    /**
     * 添加 角色
     */
    void saveRole(Role role);

    /**
     * 修改 角色
     */
    void updateRole(Role role);

    /**
     * 获取角色关联的资源信息与资源所属的分类信息
     */
    List<ResourceCategory> findResourceAndCategoryByRoleId(int roleId);

    /**
     * 更新角色所拥有的的资源
     */
    void updateRoleResource(RoleResourceVo roleResourceVo);
}
