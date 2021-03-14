package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.MenuMapper;
import com.lagou.entity.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    /**
     * 查询所有菜单信息 [分页查询]
     * @return
     */
    @Override
    public PageInfo<Menu> findAllMenu(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Menu> menus = menuMapper.findAllMenu();
        return new PageInfo<>(menus);
    }
    /**
     * 根据父菜单id获取子菜单 【树形结构】
     */
    @Override
    public List<Menu> findSubMenuListByPid(int parentId) {
        return menuMapper.findSubMenuListByPid(parentId);
    }
    /**
     * 根据ID 查找菜单
     */
    @Override
    public Menu findMenuById(int id) {
        return menuMapper.findMenuById(id);
    }

    /**
     * 创建 菜单
     */
    @Override
    public int saveMenu(Menu menu) {
        // 信息补全
        if(menu.getParentId()==-1){
            // 顶级菜单
            menu.setLevel(0);
        }else{
            // 二级菜单
            menu.setLevel(1);
        }
        Date now = new Date();
        menu.setCreatedTime(now);
        menu.setUpdatedTime(now);
        menu.setCreatedBy("SYSTEM");
        menu.setUpdatedBy("SYSTEM");

        return menuMapper.saveMenu(menu);
    }
    /**
     * 修改 菜单
     */
    @Override
    public int updateMenu(Menu menu) {
        // 信息补全
        if(menu.getParentId()==-1){
            // 顶级菜单
            menu.setLevel(0);
        }else{
            // 二级菜单
            menu.setLevel(1);
        }
        Date now = new Date();
        menu.setUpdatedTime(now);
        menu.setUpdatedBy("SYSTEM");
        return menuMapper.updateMenu(menu);
    }

    /**
     * 删除菜单
     */
    @Override
    public String deleteMenu(int id) {
        // 是否有子菜单
        List<Menu> subMenus = menuMapper.findSubMenuListByPid(id);
        if(subMenus.size()==0){
            // 没有子菜单时，才能删除
            menuMapper.deleteMenu(id);
            return "删除成功";
        }
        return "删除失败： 请先删除该菜单的子菜单。";
    }
}
