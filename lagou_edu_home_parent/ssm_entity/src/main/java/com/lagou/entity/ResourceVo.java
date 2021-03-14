package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 资源 多条件 分页查询
 */
@Data
@ToString(doNotUseGetters = true)
public class ResourceVo {
    // 分页信息
    private Integer currentPage;
    private Integer pageSize;
    // 资源 名称
    private String name;
    // 资源路径
    private String url;
    // 资源分类
    private Integer categoryId;
}
