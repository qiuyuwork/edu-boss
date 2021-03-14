package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.Menu;
import com.lagou.entity.ResponseResult;
import com.lagou.service.MenuService;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单信息 [分页查询]
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(Integer currentPage,Integer pageSize){
        PageInfo<Menu> menus = menuService.findAllMenu(currentPage,pageSize);
        return new ResponseResult(menus);
    }

    /**
     * 编辑菜单时，要回显的菜单信息
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){
        if(id==-1){
            // 新增菜单，只返回顶级菜单信息即可
            List<Menu> menus = menuService.findSubMenuListByPid(-1);
            // 子菜Menu单不返回
            for (Menu menu : menus) {
                menu.setSubMenuList(null);
            }
            Map<String,Object> content = new HashMap<>();
            content.put("menuInfo",null);
            content.put("parentMenuList",menus);

            return new ResponseResult(content);
        }else{
            // 修改菜单时，要返回本菜单信息
            Menu menu = menuService.findMenuById(id);
            // 顶级菜单信息
            List<Menu> menus = menuService.findSubMenuListByPid(-1);
            // 子菜单不返回
            for (Menu m : menus) {
                m.setSubMenuList(null);
            }

            Map<String,Object> content = new HashMap<>();
            content.put("menuInfo",menu);
            content.put("parentMenuList",menus);

            return new ResponseResult(content);
        }
    }
    /**
     * 添加或者修改 菜单
     */
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu){
        if(menu.getId()==null){
            // 创建 菜单
            menuService.saveMenu(menu);
            return new ResponseResult("创建菜单成功",null);
        }else{
            // 修改菜单
            menuService.updateMenu(menu);
            return new ResponseResult("修改菜单成功", null);
        }
    }

    /**
     * 删除菜单
     */
    @RequestMapping("/deleteMenu")
    public ResponseResult deleteMenu(Integer id){
        String res = menuService.deleteMenu(id);
        if("删除成功".equals(res)){
            return new ResponseResult(res, null);
        }else {
            return new ResponseResult(true, 500, res, null);
        }
    }
}
