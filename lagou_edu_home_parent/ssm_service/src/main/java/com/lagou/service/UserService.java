package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.Role;
import com.lagou.entity.User;
import com.lagou.entity.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 分页 模糊查询 用户信息
     *
     * @return
     */
    PageInfo<User> findAllUserByPage(UserVo userVo);

    /**
     * 根据Id修改用户状态
     */
    void updateUserStatus(User user);

    /**
     * 用户登录
     */
    User login(User user) throws Exception;

    /**
     * 回显用户角色信息
     */
    List<Role> findUserRoleBy(int userId);

    /**
     * 更新用户角色
     */
    void updateUserRole(UserVo userVo);

    /**
     * 获取用户权限 【菜单列表，资源列表】
     */
    Map<String,Object> getUserPermissions(int userId);
}
