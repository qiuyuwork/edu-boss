package com.lagou.controller;

import com.lagou.entity.Course;
import com.lagou.entity.CourseLesson;
import com.lagou.entity.CourseSection;
import com.lagou.entity.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    /**
     * 根据课程id 获取 章节、课时 信息
     * @param courseId
     * @return
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(Integer courseId){
        List<CourseSection> sectionAndLesson = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(sectionAndLesson);
    }

    /**
     * 根据课程id获取课程名
     * @param courseId
     * @return
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        return new ResponseResult(course);
    }

    /**
     * 添加或更新课程章节
     * @param courseSection
     * @return
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        courseContentService.saveOrUpdateSection(courseSection);
        return new ResponseResult(null);
    }

    /**
     * 更新 章节状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(Integer id,Integer status){
        courseContentService.updateSectionStatus(id,status);

        Map<String,Object> info = new HashMap<>();
        info.put("status",status);

        return new ResponseResult(info);
    }

    /**
     * 添加 或 修改 课时
     */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveLesson(@RequestBody CourseLesson courseLesson){
        if(courseLesson.getId()==null){
            // 创建
            courseContentService.saveLession(courseLesson);
            return new ResponseResult(true,200,"创建成功",null);
        }else{
            courseContentService.updateLession(courseLesson);
            return new ResponseResult(true,200,"修改成功",null);
        }
    }

    /**
     * 修改课时状态
     */
    @RequestMapping("/updateLessonStatus")
    public ResponseResult updateLessonStatus(CourseLesson lesson){
        courseContentService.updateLessonStatus(lesson);

        Map<String,Object> info = new HashMap<>(1);
        info.put("status",lesson.getStatus());

        return new ResponseResult(info);
    }


}
