package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 教师类
 * */
@Data
@ToString(doNotUseGetters = true)
public class Teacher {

    //id
    private Integer id;

    //课程id
    private Integer courseId;

    //讲师姓名
    private String teacherName;

    //讲师职务
    private String position;

    //介绍
    private String description;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //是否删除
    private Integer isDel;

}
