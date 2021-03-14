package com.lagou.dao;

import com.lagou.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有角色，查询条件：角色名称
     */
    List<Role> findAllRole(Role role);

    /**
     * 根据角色Id 查找关联菜单的Id
     */
    List<Integer> findMenuByRoleId(int roleId);

    /**
     * 清空对应的 角色-菜单 关系
     */
    int deleteRoleMenuRelations(Integer roleId);
    /**
     * 重建 角色-菜单 关系
     */
    int buildRoleMenuRelation(Role_menu_relation role_menu_relation);

    /**
     * 删除 角色
     */
    int deleteRole(int id);

    /**
     * 添加 角色
     */
    int saveRole(Role role);

    /**
     * 修改 角色
     */
    int updateRole(Role role);

    /**
     * 根据角色Id  查找资源
     */
    List<Resource> findResourceByRoleId(int roleId);

    /**
     * 清除角色资源绑定
     */
    int deleteRoleResource(int roleId);

    /**
     * 重新为角色添加资源
     */
    int addRoleResource(RoleResourceRelation roleResourceRelation);
}
