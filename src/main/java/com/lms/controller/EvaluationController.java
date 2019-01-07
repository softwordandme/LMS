package com.lms.controller;

import com.alibaba.fastjson.JSON;
import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EvaluationController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    CourseService courseService;
    @Autowired
    TermService termService;
    @Autowired
    QuotaService quotaService;
    @Autowired
    EvaluationService evaluationService;
    @Autowired
    EvaluationTypeService evaluationTypeService;
    @Autowired
    RoleService roleService;

    /**
     * 学生选择评教页面
     */
    @RequestMapping("/studentEvaluation")
    public String student(HttpServletRequest request, Model model){
        //加载学年学期
        Term term = evaluationService.findTermByStatus();
        model.addAttribute("term",term);
        //获取学年学期
        Integer termId = term.getTermId();
        //session
        HttpSession session = request.getSession();
        //这里是获取学生学号
        String userId = (String) session.getAttribute("userId");
        if (userId==null){
            return "error_no_login";
        }
        //查看学生评教开启状态
        String roleIdS =  (String)session.getAttribute("roleType");
        Integer roleId = Integer.parseInt(roleIdS);
        if (roleId != 1){
            return "index";
        }
        //获取当前学生所有信息
        Student student = studentService.findStudentAll(userId);
        //获取学生所在班级的课程信息
        List<Clazz> clazzs = clazzService.findClazzAllByClazzNum(student.getClazzNum());
        //初始化课程list
        List<Course> courseList = new ArrayList<>();
        //初始化
        Course course;

        Map<String,Integer> sign = new HashMap<>(16);

        List<Clazz> clazzeM = new ArrayList<>();

        //获取查询当前学期的班级的课程
        for(Clazz c:clazzs){
            course = courseService.findByCourseIdAndTermId(c.getCourseId(),termId);
            if(course != null){
                courseList.add(course);
                clazzeM.add(c);
                sign.putAll(evaluationService.findEvaluationByCourseIdAndClazzNumAndEvaluationJudgesId(course.getCourseId(),c.getClazzNum(),userId));
            }
        }

        EvaluationType evaluationType = evaluationTypeService.findAllByRoleId(roleId);
        model.addAttribute("evaluationType",evaluationType);
        model.addAttribute("clazzNum",student.getClazzNum());
        model.addAttribute("sign",sign);
        model.addAttribute("courseList", courseList);
        model.addAttribute("teachers",teacherService.findTeacherAll());
        return "teachAssessment/studentevaluation";

    }

    /**
     * 教师、系主任选择评教页面
     */
    @RequestMapping("/teacherEvaluation")
    public String deanEvaluation(HttpServletRequest request, Model model){
        //加载学年学期
        Term term = evaluationService.findTermByStatus();
        model.addAttribute("term",term);
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String roleIdS = (String) session.getAttribute("roleType");
        Integer roleId = Integer.parseInt(roleIdS);
        String deanName = "系主任";
        String teacherName = "教师";
        //获取系主任
        Role role = roleService.findRoleByRoleName(deanName);
        //获取教师
        Role role1 = roleService.findRoleByRoleName(teacherName);

        Teacher teacher = teacherService.findAllByTeacherNo(userId);
        String departmentName = departmentService.findDepartmentNameById(teacher.getDepartmentId());
        List<Teacher> teacherList = new ArrayList<>();
        if (roleId.equals(role.getRoleId())){
            //查询部门所有教师
            teacherList = teacherService.findTeachersByDepartmentId(teacher.getDepartmentId());
            //标识是否评价

            model.addAttribute("sign",evaluationService.teacherSign(teacherList,userId,term.getTermId()));

        }else if (roleId.equals(role1.getRoleId())){
            //查询部门不是系主任的所有教师
            teacherList = teacherService.findTeachersByDepartmentIdAndRoleId(teacher.getDepartmentId(),role1.getRoleId().toString());
            //标识是否评价
            model.addAttribute("sign",evaluationService.teacherSign(teacherList,userId,term.getTermId()));
        }

        //查看当前角色评教是否开启
        EvaluationType evaluationType = evaluationTypeService.findAllByRoleId(roleId);
        model.addAttribute("evaluationType",evaluationType);

        request.setAttribute("departmentName",departmentName);
        model.addAttribute("teacherList",teacherList);
        return "teachAssessment/teacherEvaluation";
    }

    /**
     * 学生开始评教页面
     */
    @RequestMapping("/startEvaluation")
    public String startEvaluation(Integer courseId,Model model){
        Course course = courseService.findCourseByCourseId(courseId);
        Teacher teacher = teacherService.findAllByTeacherNo(course.getTeacherNo());
        Term term = termService.findAllBytermId(course.getTermId());
        model.addAttribute("course",course);
        model.addAttribute("teacher",teacher);
        model.addAttribute("term",term);
        return "teachAssessment/studentStartEvaluation";
    }


    /**
     * 教师、系主任开始评教页面
     */
    @RequestMapping("/teacherStartEvaluation")
    public String startEvaluationDean(String teacherNo,Integer termId,Model model){
        Teacher teacher = teacherService.findAllByTeacherNo(teacherNo);
        Term term = termService.findAllBytermId(termId);
        model.addAttribute("teacher",teacher);
        model.addAttribute("term",term);
        return "teachAssessment/teacherStartEvaluation";
    }


    /**
     * 评教指标加载
     */
    @RequestMapping("evaluationQuotaLoad")
    @ResponseBody
    public String evaluationQuotaLoad(Integer roleId){
        List<Quota> quotas = quotaService.findQuotasByQuotaType(roleId);
        String quotaJson = JSON.toJSONString(quotas);
        return quotaJson;
    }

    /**
     * 评教分数提交
     */
    @RequestMapping("evaluationScoreDo")
    @ResponseBody
    public String evaluationScoreDo(String evaluationJudgesId, String evaluationPlayerId, BigDecimal score,Integer termId,Integer courseId){
        return evaluationService.evaluationScoreDo(evaluationJudgesId,evaluationPlayerId,score,termId,courseId);
    }

}
