package com.lagou.dao;

import com.lagou.entity.Course;
import com.lagou.entity.CourseVo;
import com.lagou.entity.Teacher;

import java.util.List;

/**
 * @author 默尘
 */
public interface CourseMapper {
    /**
     * 查询所有账户信息
     * @return
     */
    List<Course> findCourseByCondition(CourseVo courseVo);

    /**
     * 保存课程信息
     */
    public int saveCourse(Course course);
    /**
     * 保存讲师信息
     * */
    public void saveTeacher(Teacher teacher);

    /**
     * 根据 课程id 获取 课程及讲师信息
     * @param courseId
     * @return
     */
    public CourseVo findCourseById(Integer courseId);

    /**
     * 更新 课程信息
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 跟新 讲师信息
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 更新 课程状态
     * @param course
     * @return
     */
    int updateCourseStatus(Course course);
}
