package com.lagou.controller;

import com.github.pagehelper.parser.impl.HsqldbParser;
import com.lagou.commom.Config;
import com.lagou.entity.Course;
import com.lagou.entity.CourseVo;
import com.lagou.entity.ResponseResult;
import com.lagou.service.CourseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 默尘
 */
@RestController
@RequestMapping("/course")
@Log4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 多条件查询
     * @param courseVo
     * @return
     */
    @RequestMapping("/findAllCourse")
    public ResponseResult findCourseByCondition(@RequestBody CourseVo courseVo){
        List<Course> courseList = courseService.findCourseByCondition(courseVo);
        return new ResponseResult(true,200,"响应成功",courseList);
    }

    /**
     * 封面图片上传
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/courseUpload")
    public ResponseResult courseUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        // 拼接图片存储目录
        File realPath = new File(request.getServletContext().getRealPath("/"));
        File imgStore = new File(realPath.getParent(), Config.IMGSTORE);
        if(!imgStore.exists()){
            imgStore.mkdirs();
        }
        // 新文件名
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        // 拷贝文件
        file.transferTo(new File(imgStore,fileName));
        // 返回信息
        Map<String,String> info = new HashMap<>();
        info.put("fileName",fileName);
        info.put("filePath",Config.DOMAIN+"/"+Config.IMGSTORE+"/"+fileName);

        return new ResponseResult(info);
    }

    /**
     * 创建 或 更新 课程信息
     * @param courseVo
     * @return
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVo courseVo){
        if(null == courseVo.getId()) {
            courseService.saveCourseOrTeacher(courseVo);
            return new ResponseResult(true,200,"保存成功",null);
        }else{
            courseService.updateCourseOrTeacher(courseVo);
            return new ResponseResult(true,200,"更新成功",null);
        }
    }

    /**
     * 根据 课程id 获取课程信息
     * @param id
     * @return
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        CourseVo course = courseService.findCourseById(id);
        return new ResponseResult(course);
    }

    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id,Integer status){
        courseService.updateCourseStatus(id,status);

        Map<String,Object> info = new HashMap<>();
        info.put("status",status);
        return new ResponseResult(info);
    }
}
