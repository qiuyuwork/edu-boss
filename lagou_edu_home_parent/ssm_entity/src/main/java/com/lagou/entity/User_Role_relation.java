package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString(doNotUseGetters = true)
public class User_Role_relation {

    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedby;

}
