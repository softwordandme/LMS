package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    TermService termService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClazzService clazzService;
    @RequestMapping("/courseManagement")
    public String courseManagement(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("course", courses);
        model.addAttribute("terms", termService.findAll());
        model.addAttribute("teacherList", teacherService.findTeacherAll());
        return "basicManagement/courseManagement";
    }

    @RequestMapping("/delCourse")
    @ResponseBody
    public String delCourse(Integer courseId) {
        clazzService.deleteAllByCourseId(courseId);
        int state = courseService.deleteCourseByCourseId(courseId);
        if (state > 0) {
            return "1";
        }
        return "0";
    }

    @RequestMapping("/addCourse")
    public String addCourse(Model model) {
        //加载学年学期
        model.addAttribute("termNames",termService.findAll());
        return "basicManagement/addCourse";
    }

    /**
     * 进行增加Course
     **/
    @RequestMapping("/addCourseDo")
    @ResponseBody
    public String addCourseDo(Course course) {
        int co = courseService.addCourseDo(course);
        if (co != 0) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 通过teacherNo显示教师名字
     */
    @RequestMapping("/showTeacherName")
    @ResponseBody
    public String showTeacherName(String teacherNo){
        Teacher teacher = teacherService.findAllByTeacherNo(teacherNo);
        if(teacher != null ){
            return teacher.getTeacherName();
        }
        return null;
    }

    @RequestMapping("/editCourse")
    public String editCourse(Integer courseId, Model model) {
        Course course = courseService.findCourseByCourseId(courseId);
        model.addAttribute("course", course);
        //加载学年学期
        model.addAttribute("termNames",termService.findAll());
        return "basicManagement/editCourse";
    }

    @RequestMapping("/editCourseDo")
    @ResponseBody
    public String editCourseDo(Course course) {
        List<Clazz> clazzeList=courseService.findClazzesByCourseId(course.getCourseId());
        String courseName=course.getCourseName();
        for(Clazz cl:clazzeList){
            cl.setCourseName(courseName);
            clazzService.editClazzDo(cl);
        }
        int result = courseService.editCourseDo(course);
        if (result ==1) {
            return "1";
        }else {
            return "0";
        }
    }
}