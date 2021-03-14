package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.entity.ResponseResult;
import com.lagou.entity.Role;
import com.lagou.entity.User;
import com.lagou.entity.UserVo;
import com.lagou.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页 模糊查询 用户信息
     */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        PageInfo<User> users = userService.findAllUserByPage(userVo);
        System.out.println("####$$$$:startTime: "+userVo.getStartCreateTime());
        return new ResponseResult(users);
    }

    /**
     * 根据Id修改用户状态
     */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(User user){
        userService.updateUserStatus(user);
        return new ResponseResult(user.getStatus());
    }

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpSession session) throws Exception {
        User user2 = userService.login(user);
        if(user2!=null){
            // 登录成功
            String accessToken = UUID.randomUUID().toString();
            session.setAttribute("access_token",accessToken);
            session.setAttribute("user_id",user2.getId());
            // 返回数据
            Map<String,Object> info = new HashMap<>(3);
            info.put("access_token",accessToken);
            info.put("user_id",user2.getId());
            info.put("user",user2);
            return new ResponseResult(true,1,"登录成功",info);
        }else{
            return new ResponseResult(true,205,"用户名或密码错误！", null);
        }
    }

    /**
     * 回显用户角色信息
     */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(Integer id){
        List<Role> userRoles = userService.findUserRoleBy(id);
        return new ResponseResult(userRoles);
    }

    /**
     * 更新用户角色
     */
    @RequestMapping("/userContextRole")
    public ResponseResult updateUserRole(@RequestBody UserVo userVo){
        userService.updateUserRole(userVo);
        return new ResponseResult(null);
    }

    /**
     * 获取用户权限 【菜单列表，资源列表】
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(@NotNull HttpServletRequest request){
        String token = request.getHeader("Authorization");
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        if(token!=null&&token.equals(access_token)){
            int userId = (int) session.getAttribute("user_id");
            Map<String, Object> userPermissions = userService.getUserPermissions(userId);
            return new ResponseResult(userPermissions);
        }else{
            return new ResponseResult(false, 400, "获取失败", "");
        }
    }
}
