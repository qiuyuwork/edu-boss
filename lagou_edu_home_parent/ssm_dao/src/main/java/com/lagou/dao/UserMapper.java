package com.lagou.dao;

import com.lagou.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Date;
import java.util.List;

public interface UserMapper {

    /**
     * 根据 用户名 及 注册时间 查询用户
     */
    List<User> findAllUserByPage(
            @Param("username") String username,
            @Param("startCreateTime") Date startCreateTime,
            @Param("endCreateTime") Date endCreateTime);

    /**
     * 根据Id修改用户状态
     */
    int updateUserStatus(User user);

    /**
     * 用户登录
     */
    User login(User user);

    /**
     * 用户 角色 回显
     */
    List<Role> findUserRoleById(int userId);

    /**
     * 清除用户角色
     */
    int deleteUserRoles(int userId);

    /**
     * 重建用户角色
     */
    int buildUserRole(User_Role_relation user_role_relation);

    /**
     * 根据角色id 获取顶级菜单
     */
    List<Menu> findParentMenuByURoleId(List<Integer> roleId);

    /**
     * 根据 父菜单id 查询 子菜单
     */
    List<Menu> findSubMenuByPid(int parentId);

    /**
     * 根据 用户ID 获取 用户资源
     */
    List<Resource> findResourceByRoleId(List<Integer> roleId);
}
