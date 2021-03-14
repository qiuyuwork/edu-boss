package com.lagou.service;

import com.lagou.entity.Course;
import com.lagou.entity.CourseVo;

import java.util.List;

/**
 * @author 默尘
 */
public interface CourseService {
    /**
     * 获取所有的账户信息
     * @return
     */
    List<Course> findCourseByCondition(CourseVo courseVo);

    /**
     * 保存课程信息
     * */
    void saveCourseOrTeacher(CourseVo courseVo);

    /**
     * 根据课程ID 获取 课程及讲师信息
     * @param courseId
     * @return
     */
    CourseVo findCourseById(Integer courseId);

    /**
     * 更新 课程信息
     * */
    void updateCourseOrTeacher(CourseVo courseVo);

    /**
     * 更新 课程状态
     * @param courseId
     * @param status
     */
    void updateCourseStatus(int courseId,int status);
}
