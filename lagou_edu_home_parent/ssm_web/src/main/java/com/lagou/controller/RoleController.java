package com.lagou.controller;

import com.lagou.entity.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色 条件：角色名称
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> roles = roleService.findAllRole(role);
        return new ResponseResult(roles);
    }

    /**
     * 查询所有菜单【树形结构】
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> allMenu = roleService.findAllMenu();
        Map<String,Object> content = new HashMap<>();
        content.put("parentMenuList",allMenu);
        return new ResponseResult(content);
    }

    /**
     * 根据角色Id 查找关联菜单的Id
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<Integer> menuIds = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(menuIds);
    }

    /**
     * 更新 角色-菜单 关系
     */
    @RequestMapping("/RoleContextMenu")
    private ResponseResult roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.updateRoleMenuRelation(roleMenuVo);
        return new ResponseResult("更新角色菜单关系，成功", null);
    }

    /**
     * 删除 角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        return new ResponseResult(null);
    }

    /**
     * 添加&修改 角色
     */
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role){
        if(role.getId()==null){
            // 添加角色
            roleService.saveRole(role);
        }else{
            // 更新角色
            roleService.updateRole(role);
        }
        return new ResponseResult(null);
    }

    /**
     * 获取当前角色拥有的资源信息
     */
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(Integer roleId){
        List<ResourceCategory> resourceCategoryList = roleService.findResourceAndCategoryByRoleId(roleId);
        return new ResponseResult(resourceCategoryList);
    }

    /**
     * 更新角色所拥有的的资源
     */
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVo roleResourceVo){
        roleService.updateRoleResource(roleResourceVo);
        return new ResponseResult("角色资源更新成功");
    }
}
