package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.entity.Course;
import com.lagou.entity.CourseVo;
import com.lagou.entity.Teacher;
import com.lagou.service.CourseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
@Service
@Log4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVo courseVo) {
        return courseMapper.findCourseByCondition(courseVo);
    }

    @Override
    public void saveCourseOrTeacher(CourseVo courseVo) {
        log.debug("保存课程信息："+courseVo);
        // 封装Course对象
        Course course = new Course();
        BeanUtils.copyProperties(courseVo,course);
        // 补全Course信息
        Date now = new Date();
        course.setCreateTime(now);
        course.setUpdateTime(now);
        // 保存信息
//        log.debug(course);
        courseMapper.saveCourse(course);

        // 获取新插入的课程id
        Integer courseId = course.getId();
        // 分装Teacher对象
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(courseVo,teacher);
        // 补全信息
        teacher.setCourseId(courseId);
        teacher.setCreateTime(now);
        teacher.setUpdateTime(now);
        // 保存讲师信息
//        log.debug(teacher);
        courseMapper.saveTeacher(teacher);
    }

    /**
     * 根据课程ID 获取 课程及讲师信息
     * @param courseId
     * @return
     */
    @Override
    public CourseVo findCourseById(Integer courseId) {
        return courseMapper.findCourseById(courseId);
    }

    /**
     * 更新课程信息
     * @param courseVo
     */
    @Override
    public void updateCourseOrTeacher(CourseVo courseVo) {
        log.debug("更新课程信息："+courseVo);
        // 封装Course对象
        Course course = new Course();
        BeanUtils.copyProperties(courseVo,course);
        // 补全Course信息
        Date now = new Date();
        course.setUpdateTime(now);
        // 保存信息
//        log.debug(course);
        courseMapper.updateCourse(course);

        // 获取新插入的课程id
        Integer courseId = course.getId();
        // 分装Teacher对象
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(courseVo,teacher);
        // 补全信息
        teacher.setCourseId(courseId);
        teacher.setUpdateTime(now);
        // 保存讲师信息
//        log.debug(teacher);
        courseMapper.updateTeacher(teacher);
    }

    /**
     * 变更 课程状态
     * @param courseId
     * @param status
     */
    @Override
    public void updateCourseStatus(int courseId, int status) {
        // 分装course实体，添加更新时间
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(new Date());
        // 更新课程状态
        courseMapper.updateCourseStatus(course);
    }
}
