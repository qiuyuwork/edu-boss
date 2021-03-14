package com.lagou.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(doNotUseGetters = true)
public class PromotionSpace {

    private Integer id;
    private String name;
    private String spaceKey;
    private Date createTime;
    private Date updateTime;
    private Integer isDel;
}
