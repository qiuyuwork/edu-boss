package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(doNotUseGetters = true)
public class RoleResourceRelation {

    private Integer id;
    private Integer resourceId;
    private Integer roleId;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;

}
