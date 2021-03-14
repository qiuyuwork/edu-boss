package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.entity.Course;
import com.lagou.entity.CourseLesson;
import com.lagou.entity.CourseSection;
import com.lagou.service.CourseContentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@Log4j
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    /**
     * 根据 课程Id 获取 课时及章节信息
     * @param courseId
     * @return
     */
    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    /**
     * 根据 课程id 获取课程名 和 课程id
     * @param courseId
     * @return
     */
    @Override
    public Course findCourseByCourseId(int courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    /**
     * 创建或保存章节信息
     * @param courseSection
     */
    @Override
    public void saveOrUpdateSection(CourseSection courseSection) {
        if(courseSection.getId()==null) {
            // 创建 操作
            // 补全信息
            Date now = new Date();
            courseSection.setCreateTime(now);
            courseSection.setUpdateTime(now);
            log.debug("$$$:"+courseSection);
            // 创建 章节
            courseContentMapper.saveSection(courseSection);
        }else{
            // 修改 章节
            // 补全信息
            courseSection.setUpdateTime(new Date());
            // 修改
            courseContentMapper.updateSection(courseSection);
        }
    }

    /**
     * 修改 章节状态
     * @param sectionId
     * @param status
     * @return
     */
    @Override
    public int updateSectionStatus(Integer sectionId, Integer status) {
        CourseSection section = new CourseSection();
        section.setId(sectionId);
        section.setStatus(status);
        section.setUpdateTime(new Date());
        return courseContentMapper.updateSectionStatus(section);
    }

    /**
     * 添加 课时
     * @param courseLesson
     * @return
     */
    @Override
    public int saveLession(CourseLesson courseLesson) {
        // 补全信息
        Date now = new Date();
        courseLesson.setCreateTime(now);
        courseLesson.setUpdateTime(now);
        return courseContentMapper.saveLession(courseLesson);
    }

    /**
     * 修改 课时
     * @param courseLesson
     * @return
     */
    @Override
    public int updateLession(CourseLesson courseLesson) {
        // 补 修改时间
        courseLesson.setUpdateTime(new Date());
        return courseContentMapper.updateLession(courseLesson);
    }

    /**
     * 修改课时状态
     */
    @Override
    public void updateLessonStatus(CourseLesson lesson) {
        courseContentMapper.updateLessonStatus(lesson);
    }
}
