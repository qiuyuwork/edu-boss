package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(doNotUseGetters = true)
public class Role {

    private Integer id;
    private String code;
    private String name;
    private String description;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;

}
