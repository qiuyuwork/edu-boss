package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(doNotUseGetters = true)
public class CourseVo {

    //主键
    private Integer id;

    //课程名称
    private String courseName;

    //课程一句话简介
    private String brief;

    //原价
    private double price;

    //原价标签
    private String priceTag;

    //优惠价
    private double discounts;

    //优惠价标签
    private String discountsTag;

    //课程内容markdown
    private String courseDescriptionMarkDown;

    //课程描述
    private String courseDescription;

    //课程分享图片url
    private String courseImgUrl;

    //是否新品
    private int isNew;

    //广告语
    private String isNewDes;

    //最后操作者
    private int lastOperatorId;

    //自动上架时间
    private Date autoOnlineTime;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //是否删除
    private int isDel;

    //总时长
    private int totalDuration;

    //课程列表展示图片
    private String courseListImg;

    //课程状态，0-草稿，1-上架
    private int status;

    //课程排序
    private int sortNum;

    //课程预览第一个字段
    private String previewFirstField;

    //课程预览第二个字段
    private String previewSecondField;

    //销量
    private int sales;


    /* 讲师信息 */
    //讲师姓名
    private String teacherName;

    //讲师职务
    private String position;

    //介绍
    private String description;


}
