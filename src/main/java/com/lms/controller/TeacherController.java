package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    RoleService roleService;

    @RequestMapping("/teacherManagement")
    public String teacherManagement(Model model){
        //查询所有Teacher记录放入集合中
        List<Teacher> teacher=teacherService.findTeacherAll();
        model.addAttribute("teacher",teacher);
        List<Department> departmentList=teacherService.findAllDepartment();
        model.addAttribute("departmentList",departmentList);
        List<Role> roles=teacherService.findAllRoles();
        model.addAttribute("role",roles);
        return "basicManagement/teacherManagement";
    }

    @RequestMapping("/delTeacher")
    @ResponseBody
    public  String delTeacher(String teacherNo){
        Integer state=teacherService.deleteTeacherByTeacherNo(teacherNo);
        List<Course> courseList=teacherService.findCoursesByTeacherNo(teacherNo);
        teacherService.deleteCoursesByTeacherNo(teacherNo);
        for (Course course:courseList){
            teacherService.deleteClazzesByCourseId(course.getCourseId());
        }
        if (state>0){
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping("/addTeacher")
    public String addTeacher(Model model){
        List<Department> department=teacherService.findAllDepartment();
        List<Role> roles=roleService.findAllRole();
        model.addAttribute("department",department);
        model.addAttribute("role",roles);
        return "basicManagement/addTeacher";
    }
    /**
     * 进行增加Teacher操作
     * */
    @RequestMapping("/addTeacherDo")
    @ResponseBody
    public String addTeacherDo(Teacher teacher){
        Teacher t1=teacherService.findAllByTeacherNo(teacher.getTeacherNo());
        if(t1!=null){
            return "2";
        }
        Teacher te=teacherService.addTeacher(teacher);
        if (te!=null){
            return "1";
        }
        else {
            return "0";
        }
    }
    @RequestMapping("/editTeacher")
    public String editTeacher(String teacherNo,Model model){
        Teacher teacher=teacherService.findAllByTeacherNo(teacherNo);
        List<Department> department=teacherService.findAllDepartment();
        List<Role> roles=teacherService.findAllRoles();
        model.addAttribute("teacher", teacher);
        model.addAttribute("department",department);
        model.addAttribute("role",roles);
        return "basicManagement/editTeacher";
    }
    @RequestMapping("/editTeacherDo")
    @ResponseBody
    public  String editTeacherDo(Teacher teacher,@RequestParam(value = "YorNChangePas")Integer yorNChangePas){
        Teacher t1=teacherService.findTeacherByTeacherNoWithTeacherId(teacher.getTeacherNo(),teacher.getTeacherId());
        if(t1!=null){
            return "2";
        }
        Teacher te=teacherService.editTeacher(teacher);
        if(yorNChangePas>0){
            //MD5加密
            teacher.setTeacherPassword(DigestUtils.md5DigestAsHex(teacher.getTeacherPassword().getBytes()));
        }
        if (te!=null){
            return "1";
        }else {
            return "0";
        }
    }

    /**
     * 导入excel
     * */
    @RequestMapping("importExcelTeacher")
    @ResponseBody
    public  String importExcelTeacher(@RequestParam("doc-form-file") MultipartFile file) {

        if (file == null) {
            return "1";
        }
        List<Teacher> teachers = new ArrayList<>();
        try {
           if(file.getOriginalFilename().endsWith(".xlsx")){
                XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
                //HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
                //有多少个sheet
                int sheets = workbook.getNumberOfSheets();
                for (int i = 0; i < sheets; i++) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    //获取多少行
                    int rows = sheet.getPhysicalNumberOfRows();
                    Teacher teacher = null;
                    //遍历每一行，注意：第 0 行为标题
                    for (int j = 1; j < rows; j++) {
                        teacher = new Teacher();
                        //获得第 j 行
                        XSSFRow row = sheet.getRow(j);
                        //放入教师部门编号
                        teacher.setDepartmentId(new Double(row.getCell(1).getNumericCellValue()).intValue());
                        Integer se=new Double(row.getCell(2).getNumericCellValue()).intValue();
                        //放入角色id
                        teacher.setRoleId(se.toString());
                        teacher.setTeacherName(row.getCell(3).getStringCellValue());
                        row.getCell(4).setCellType(CellType.STRING);
                        teacher.setTeacherNo(row.getCell(4).getStringCellValue());
                        row.getCell(5).setCellType(CellType.STRING);
                        teacher.setTeacherPassword(row.getCell(5).getStringCellValue());
                        teacher.setTeacherSex(row.getCell(6).getStringCellValue());
                        teacher.setTeacherStatus(row.getCell(7).getStringCellValue());
                        teachers.add(teacher);
                    }
                }
            }else {
                return "0";
            }
            
            if(teachers.isEmpty()){
                return "2";
            }else {
                for (Teacher list:teachers){
                    teacherService.addTeacher(list);
                }
                return "3";
            }
        } catch (IOException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "0";

    }

}
