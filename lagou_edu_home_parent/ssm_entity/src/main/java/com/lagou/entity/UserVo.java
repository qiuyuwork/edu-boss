package com.lagou.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@ToString(doNotUseGetters = true)
public class UserVo {

    /* 多条件分页查询 */
    // 当前页
    private Integer currentPage;
    // 页容量
    private Integer pageSize;
    // 起止日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date endCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date startCreateTime;
    // 用户名
    private String username;


    /* 更新 角色 */
    // 用户id
    private Integer userId;
    // 角色Id
    private List<Integer>  roleIdList;

}
