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
public class StudentManagementController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/showClazz")
    public String showClazz(Model model){
        List<Student> students=studentService.findAll();
        List<Clazz> clazzes = clazzService.findAll();
        List<String> department=new ArrayList<>();
        for (Clazz list:clazzes){
            department.add(departmentService.findDepartmentByDepartmentId(list.getDepartment()).getDepartmentName());
        }
        model.addAttribute("clazz",clazzes);
        model.addAttribute("department",department);
        return "basicManagement/showClazz";
    }
    @RequestMapping("/studentManagement")
    public String  studentManagement(Model model){
        List<Student> students=studentService.findAll();
        List<Department> departmentList=departmentService.findAll();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("student",students);
        return "basicManagement/studentManagement";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("clazz",clazzService.findAll());
        model.addAttribute("department",departmentService.findAll());
        List<Integer> clazzNumList=studentService.findDistinctClazzNum();
        model.addAttribute("clazzNumList",clazzNumList);
        return "basicManagement/addStudent";
    }
    @RequestMapping("/addStudentDo")
    @ResponseBody
    public String addStudentDo(Student student){
        Student student1=studentService.findStudentByStudentNo(student.getStudentNo());
        if(student1!=null){
            return "2";
        }
        int st= studentService.addStudentDo(student);
        if (st!=0){
            return "1";
        }
        else {
            return "0";
        }
    }
    @RequestMapping("/editStudent")
    public String editStudent(Integer studentId,Model model){
        Student student=studentService.findStudentByStudentId(studentId);
        model.addAttribute("student",student);
        List<Integer> clazzNumList=studentService.findDistinctClazzNum();
        model.addAttribute("clazzNumList",clazzNumList);
        model.addAttribute("department",departmentService.findAll());
        return "basicManagement/editStudent";
    }
    @RequestMapping("/editStudentDo")
    @ResponseBody
    public  String editStudentDo(Student student,@RequestParam(value = "YorNChangePas")Integer yorNChangePas){
        if(yorNChangePas>0){
            //MD5加密
            student.setStudentPassword(DigestUtils.md5DigestAsHex(student.getStudentPassword().getBytes()));
        }
        Student student1=studentService.findTeacherByStudentNoWithStudentId(student.getStudentNo(),student.getStudentId());
        if(student1!=null){
            return "2";
        }
        int st=studentService.editStudentDo(student);
        if (st!=0){
            return "1";
        }else {
            return "0";
        }
    }
    @RequestMapping("/delStudent")
    @ResponseBody
    public  String delStudent(Integer studentId){
        int stata=studentService.deleteStudentByStudentId(studentId);
        if (stata>0){
            return "1";
        }else {
            return "0";
        }
    }
    /**导入excel*/
    @RequestMapping("importExcelStudent")
    @ResponseBody
    public  String importExcel(@RequestParam("doc-form-file") MultipartFile file) {
        if (file == null) {
            return "1";
        }
        List<Student> students = new ArrayList<>();
        try {
           if(file.getOriginalFilename().endsWith(".xlsx")){
                XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
                //有多少个sheet
                int sheets = workbook.getNumberOfSheets();
                for (int i = 0; i < sheets; i++) {
                    XSSFSheet sheet = workbook.getSheetAt(i);

                    //获取多少行
                    int rows = sheet.getPhysicalNumberOfRows();
                    Student student = null;
                    //遍历每一行，注意：第 0 行为标题
                    for (int j = 1; j < rows; j++) {
                        student = new Student();
                        //获得第 j 行
                        XSSFRow row = sheet.getRow(j);
                        row.getCell(1).setCellType(CellType.STRING);
                        student.setStudentNo(row.getCell(1).getStringCellValue());
                        student.setStudentName(row.getCell(2).getStringCellValue());
                        row.getCell(3).setCellType(CellType.STRING);
                        student.setStudentPassword(row.getCell(3).getStringCellValue());
                        student.setStudentSex(row.getCell(4).getStringCellValue());
                        row.getCell(5).setCellType(CellType.STRING);
                        student.setClazzNum(Integer.parseInt(row.getCell(5).getStringCellValue()));
                        row.getCell(6).setCellType(CellType.STRING);
                        student.setRoleId(row.getCell(6).getStringCellValue());
                        row.getCell(7).setCellType(CellType.STRING);
                        student.setDepartmentId(Integer.parseInt(row.getCell(7).getStringCellValue()));
                        students.add(student);
                    }
                }
            }else {
                return "0";
            }
            if(students.isEmpty()){
                return "2";
            }else {
                for (Student list:students){
                    studentService.addStudentDo(list);
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
