package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.entity.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页 模糊查询 用户信息
     *
     * @return
     */
    @Override
    public PageInfo<User> findAllUserByPage(UserVo userVo) {
        // 开启分页
        PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());
        // 执行查询
        List<User> users = userMapper.findAllUserByPage(
                userVo.getUsername(), userVo.getStartCreateTime(), userVo.getEndCreateTime());
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    /**
     * 根据Id修改用户状态
     */
    @Override
    public void updateUserStatus(User user) {
        // 设置更新时间
        user.setUpdateTime(new Date());
        userMapper.updateUserStatus(user);
    }

    /**
     * 用户登录
     */
    @Override
    public User login(User user) throws Exception {
        User user2 = userMapper.login(user);
        if (user2 != null && Md5.verify(user.getPassword(), "lagou", user2.getPassword())) {
            return user2;
        } else {
            return null;
        }
    }

    /**
     * 回显用户角色信息
     */
    @Override
    public List<Role> findUserRoleBy(int userId) {
        return userMapper.findUserRoleById(userId);
    }

    /**
     * 更新用户角色
     */
    @Override
    public void updateUserRole(UserVo userVo) {
        // 1. 清除用户角色
        userMapper.deleteUserRoles(userVo.getUserId());
        // 2. 重建用户角色
        User_Role_relation relation = new User_Role_relation();
        relation.setUserId(userVo.getUserId());
        relation.setCreatedBy("SYSTEM");
        relation.setUpdatedby("SYSTEM");
        Date now = new Date();
        relation.setCreatedTime(now);
        relation.setUpdatedTime(now);
        for (Integer roleId : userVo.getRoleIdList()) {
            relation.setRoleId(roleId);
            userMapper.buildUserRole(relation);
        }

    }

    /**
     * 获取用户权限 【菜单列表 及 资源列表】
     */
    @Override
    public Map<String, Object> getUserPermissions(int userId) {
        // 获取用户角色列表
        List<Role> userRoles = userMapper.findUserRoleById(userId);
        if (userRoles.size() == 0) {
            return null;
        }
        List<Integer> roleIds = userRoles.stream().map(Role::getId).collect(Collectors.toList());
        // 获取顶级菜单
        List<Menu> parentMenus = userMapper.findParentMenuByURoleId(roleIds);
        // 填充 子菜单
        for (Menu menu : parentMenus) {
            List<Menu> subMenus = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenus);
        }
        // 获取资源列表
        List<Resource> resources = userMapper.findResourceByRoleId(roleIds);
        // 封装返回值
        Map<String, Object> res = new HashMap<>();
        res.put("menuList", parentMenus);
        res.put("resourceList", resources);
        return res;
    }
}
