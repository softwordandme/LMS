package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class SelfMessageService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    ClazzDao clazzDao;
    @Autowired
    RoleService roleService;

    /**
     * 查找单个学生信息
     */
    public Student findStudentAll(String studentNo){
            Student student;
            student = studentDao.findStudentByStudentNo(studentNo);
            if (student!=null){
                return student;
            }else{
                return null;
            }
    }

    /**
     * 查找单个教师信息
     */
    public Teacher findTeacherAll(String teacherNo){
        Teacher tea;
        tea = teacherDao.findAllByTeacherNo(teacherNo);
        if (tea!=null){
            return tea;
        }else{
            return null;
        }
    }

    /**
     * 由roleId查找Role表
     */
    public Role findRoleAll(Integer roleId){
        Role role;
        role = roleDao.findAllByRoleId(roleId);
        if (role!=null){
            return role;
        }else{
            return null;
        }
    }

    /**
     * 根据部门Id查询部门信息
     */
    public Department findDepartmentAll(Integer departmentId){
        Department department;
        department = departmentDao.findAllByDepartmentId(departmentId);
        if (department!=null){
            return department;
        }else{
            return null;
        }
    }

    /**
     * 根据ClazzNum查询班级信息
     */
    public Clazz findClazzAll(Integer clazzNum){
        Clazz clazz;
        clazz = clazzDao.findAllByClazzNum(clazzNum);
        if (clazz!=null){
            return clazz;
        }else{
            return null;
        }
    }

    /**
     * 学生修改密码
     */
    public String changPasswordByStudentNo(String oldPassword,String changPassword,String userId,Integer roleId){

        String cOldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        String cChangPassword = DigestUtils.md5DigestAsHex(changPassword.getBytes());
        String studentS = "学生";
        Integer studentRoleId = roleService.findRoleByRoleName(studentS).getRoleId();
        if (roleId.equals(studentRoleId)){
            Student student = studentDao.findStudentByStudentNo(userId);
            if(cOldPassword.equals(student.getStudentPassword())){
                student.setStudentPassword(cChangPassword);
                studentDao.editStudentDo(student);
                return "true";
            }else {
                //旧密码错误
                return "inc";
            }
        }else {
            Teacher teacher = teacherDao.findAllByTeacherNo(userId);
            if(cOldPassword.equals(teacher.getTeacherPassword())){
                teacher.setTeacherPassword(cChangPassword);
                teacherDao.save(teacher);
                return "true";
            }else {
                //旧密码错误
                return "inc";
            }
        }

    }


}
