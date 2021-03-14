package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
/**
 * @author 默尘
 */
@Data
@ToString(doNotUseGetters = true)
public class RoleResourceVo {

    private Integer roleId;
    private List<Integer> resourceIdList;

}
