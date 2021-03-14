package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 资源分类表
 * @author 默尘
 */
@Data
@ToString(doNotUseGetters = true)
public class ResourceCategory {

    private Integer id;
    private String name;
    private Integer sort;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;

    // 该分类的资源列表
    List<Resource> resourceList;
}
