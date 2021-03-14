package com.lagou.dao;

import com.lagou.entity.Menu;

import java.util.List;

public interface MenuMapper {
    /**
     * 根据父菜单id获取子菜单 【树形结构】
     */
    List<Menu> findSubMenuListByPid(int parentId);

    /**
     * 获取所有菜单
     */
    List<Menu> findAllMenu();

    /**
     * 根据ID 查找菜单
     */
    Menu findMenuById(int id);

    /**
     * 添加 菜单
     */
    int saveMenu(Menu menu);

    /**
     * 修改 菜单
     */
    int updateMenu(Menu menu);

    /**
     * 删除菜单
     */
    int deleteMenu(int id);


}
