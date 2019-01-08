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
public class ClassManageController {

    @Autowired
    ClazzService clazzService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;
    /**
     * 展示记录
     * */
    @RequestMapping("/classManagement")
    public String classManagement(Model model){
        //查询所有clazz记录放入集合中
        List<Clazz> clazz=clazzService.findAll();
        List<Department> departmentList=clazzService.findAllDepartment();
        model.addAttribute("clazz",clazz);
        model.addAttribute("departmentList",departmentList);
        return "basicManagement/classManagement";
    }
    /**
     * 删除操作
     * */
    @RequestMapping("/delClazz")
    @ResponseBody
    public  String delClazz(Integer id){
        int state=clazzService.deleteClazzById(id);
        if (state>0){
            return "1";
        }else {
            return "0";
        }
    }
    /**
     * 跳转到增加页面
     * */
    @RequestMapping("/addClazz")
    public String addClazz(Model model){
        List<Department> departments=clazzService.findAllDepartment();
        model.addAttribute("department",departments);
        List<Course> courses=courseService.findAll();
        List<Teacher> teacherList = teacherService.findTeacherAll();
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("course",courses);
        return "basicManagement/addClazz";
    }
    /**
     * 进行增加Clazz操作
     **/
    @RequestMapping("/addClazzDo")
    @ResponseBody
    public String addClazzDo(Clazz clazz){
        int cl=clazzService.addClazzDo(clazz);
        if (cl!=0){
            return "1";
        }else {
            return "0";
        }
    }
    /**
     * 跳转到编辑页面
     * */
    @RequestMapping("/editClazz")
    public String editClazz(Integer id,Model model){
        Clazz clazz=clazzService.findClazzById(id);
        List<Department> departments=clazzService.findAllDepartment();
        model.addAttribute("department",departments);
        model.addAttribute("clazz",clazz);
        List<Course> courses=courseService.findAll();
        List<Teacher> teacherList = teacherService.findTeacherAll();
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("course",courses);
        return "basicManagement/editClazz";
    }
    /**
     * 保存编辑的内容
     **/
    @RequestMapping("/editClazzDo")
    @ResponseBody
    public  String editClazzDo(Clazz clazz){
        int cl=clazzService.editClazzDo(clazz);
        if (cl!=0){
            return "1";
        }else {
            return "0";
        }
    }

    /**
     * 异步实时查询班级编号下的班级名
     */
    @RequestMapping("/findClazzNameByClazzNum")
    @ResponseBody
    public String findClazzNameByClazzNum(Integer clazzNum){
        Clazz c= clazzService.findFirstByClazzNum(clazzNum);
        if (c != null){
            return c.getClazzName();
        }
        return null;
    }
}
