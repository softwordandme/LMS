package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SeeEvaluationController
 *
 * @author zz
 * @date 2018/10/11
 */
@Controller
public class SeeEvaluationController {

    @Autowired
    TermService termService;
    @Autowired
    EvaluationService evaluationService;
    @Autowired
    CourseService courseService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;

    /**
     * 查看教师、系主任的评价
     */
    @RequestMapping("seeTeacherEvaluation")
    public String seeDeanEvaluation(HttpServletRequest request){
        //加载学年学期
        Term term = evaluationService.findTermByStatus();
        request.setAttribute("term",term);
        //获取登陆教师的信息
        HttpSession session = request.getSession();
        String teacherNo = (String) session.getAttribute("userId");
        Teacher teacher = teacherService.findAllByTeacherNo(teacherNo);
        //获取教师部门
        Integer departmentId = teacher.getDepartmentId();
        Department department = departmentService.findDepartmentByDepartmentId(departmentId);
        //获取部门教师、系主任列表
        List<Teacher> teacherList = teacherService.findTeachersByDepartmentId(departmentId);
        //标记系主任是否评价
        Map<String,String> teacherSign = new HashMap<>(16);
        //系主任的分数
        Map<String,BigDecimal> teacherScore = new HashMap<>(16);
        //通过学期和系主任teacherNo和教师自己的teacherNo获取评价
        for (Teacher list:teacherList){
            Evaluation evaluation = evaluationService.findEvaluationByEvaluationJudgesIdAndEvaluationPlayerIdAndEvaluationTremId(list.getTeacherNo(),teacherNo,term.getTermId());
            if (evaluation == null){
                teacherScore.put("w"+list.getTeacherNo(),null);
                teacherSign.put("w"+list.getTeacherNo(),"未评");
            }else{
                teacherSign.put("w"+list.getTeacherNo(),"已评");
                teacherScore.put("w"+list.getTeacherNo(),evaluation.getScore());
            }
        }
        List<Role> roleList = roleService.findAllRole();
        request.setAttribute("roleList",roleList);
        request.setAttribute("teacherList",teacherList);
        request.setAttribute("departmentName",department.getDepartmentName());
        request.setAttribute("teacherSign",teacherSign);
        request.setAttribute("teacherScore",teacherScore);
        return "seeEvaluation/seeTeacherEvaluation";
    }

    /**
     * 查看学生评价
     */
    @RequestMapping("seeStudentEvaluation")
    public String seeStudentEvaluation(HttpServletRequest request, Model model){
        //加载学年学期
        Term term = evaluationService.findTermByStatus();
        request.setAttribute("term",term);
        HttpSession session = request.getSession();
        String teacherNo = (String) session.getAttribute("userId");
        List<Evaluation> evaluationList = evaluationService.findEvaluationByTeacherNoAndTermId(term.getTermId(),teacherNo);
        List<Course> courses = courseService.findCoursesByTeacherNo(teacherNo);
        List<Clazz> clazzes = new ArrayList<>();
        Map<String,String> degree = new HashMap<>(16);
        //获取有此课程的班级列表
        for (Course c:courses){
            List<Clazz> list = clazzService.findClazzesByCourseId(c.getCourseId());
            for (Clazz clazz:list){
                    int all = studentService.countStudentsByClazzNum(clazz.getClazzNum());
                    int other = evaluationService.countEvaluationsByCourseIdAndClazzNum(c.getCourseId(),clazz.getClazzNum());
                    String allc = other+"/"+all;
                    degree.put("w"+c.getCourseId()+"w"+clazz.getClazzNum(),allc);
                    clazzes.add(clazz);
            }
        }

        model.addAttribute("degree",degree);
        model.addAttribute("clazzes",clazzes);
        model.addAttribute("evaluationList",evaluationList);
        model.addAttribute("courses",courses);
        return "seeEvaluation/seeStudentEvaluation";
    }
}
