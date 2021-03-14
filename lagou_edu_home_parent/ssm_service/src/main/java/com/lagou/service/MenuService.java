package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 获取所有菜单信息 [分页查询]
     * @return
     */
    PageInfo<Menu> findAllMenu(Integer currentPage, Integer pageSize);

    /**
     * 根据父菜单id获取子菜单 【树形结构】
     */
    List<Menu> findSubMenuListByPid(int parentId);

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
    String deleteMenu(int id);
}
