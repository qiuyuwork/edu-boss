package com.lagou.dao;


import com.lagou.entity.Course;
import com.lagou.entity.CourseLesson;
import com.lagou.entity.CourseSection;

import java.util.List;

public interface CourseContentMapper {
    /**
     * 根据 课程Id 获取 课时及章节信息
     * @param courseId
     * @return
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 根据 课程id 获取课程名 和 课程id
     * @param courseId
     * @return
     */
    Course findCourseByCourseId(int courseId);

    /**
     * 创建 章节信息
     * @param courseSection
     * @return
     */
    int saveSection(CourseSection courseSection);

    /**
     * 更新 章节信息
     * @param courseSection
     * @return
     */
    int updateSection(CourseSection courseSection);

    /**
     * 修改 章节状态
     * @param courseSection
     * @return
     */
    int updateSectionStatus(CourseSection courseSection);

    /**
     * 添加 课时
     * @param courseLesson
     * @return
     */
    int saveLession(CourseLesson courseLesson);

    /**
     * 修改 课时
     * @param courseLesson
     * @return
     */
    int updateLession(CourseLesson courseLesson);

    /**
     * 修改课时状态
     */
    int updateLessonStatus(CourseLesson lesson);
}
