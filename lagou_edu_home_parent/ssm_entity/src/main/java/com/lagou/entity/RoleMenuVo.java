package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString(doNotUseGetters = true)
public class RoleMenuVo {
    // 角色id
    private Integer roleId;
    // 与此角色关联的菜单
    private List<Integer> menuIdList;

}
