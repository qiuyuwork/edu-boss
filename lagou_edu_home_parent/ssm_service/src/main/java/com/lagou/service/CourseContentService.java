package com.lagou.service;

import com.lagou.entity.Course;
import com.lagou.entity.CourseLesson;
import com.lagou.entity.CourseSection;

import java.util.List;

public interface CourseContentService {

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
     * 创建或更新 章节信息
     * @param courseSection
     */
    void saveOrUpdateSection(CourseSection courseSection);

    /**
     * 修改 章节状态
     * @param sectionId
     * @param status
     * @return
     */
    int updateSectionStatus(Integer sectionId, Integer status);

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
    void updateLessonStatus(CourseLesson lesson);
}
