package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ClazzDao clazzDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有老师
     */
    public List<Teacher> findTeacherAll(){
        List<Teacher> teacher;
        teacher = teacherDao.findAll();
        if (teacher!=null){
            return teacher;
        }else{
            return null;
        }
    }

    /**
     * 通过部门Id查询部门的所有教师
     */
    public List<Teacher> findTeachersByDepartmentId(Integer departmentId){
        return teacherDao.findTeachersByDepartmentId(departmentId);
    }


    /**
     * 通过部门Id和roleId查询部门的所有教师
     */
    public List<Teacher> findTeachersByDepartmentIdAndRoleId(Integer departmentId,String roleId){
        return teacherDao.findTeachersByDepartmentIdAndRoleId(departmentId,roleId);
    }

    /**
     * 通过教师工号和教师部门查询教师信息
     */
    public Teacher findAllByTeacherNoAndDepartmentId(String teacherNo,Integer departmentId){
        return teacherDao.findAllByTeacherNoAndDepartmentId(teacherNo,departmentId);
    }
    /**
     * 查询单个
     * */
    public Teacher findAllByTeacherNo(String teacherNo){
        return teacherDao.findAllByTeacherNo(teacherNo);
    }
    /**
     * 增加一条记录
     * */
    public Teacher addTeacher(Teacher teacher){
        //MD5加密
        teacher.setTeacherPassword(DigestUtils.md5DigestAsHex(teacher.getTeacherPassword().getBytes()));
        return teacherDao.save(teacher);
    }
    /**
     * 修
     改一条记录
     * */
    public   Teacher editTeacher(Teacher teacher){
        return teacherDao.save(teacher);
    }
    /**
     * 删除一条记录
     * */
    public int deleteTeacherByTeacherNo(String teacherNo){
        return  teacherDao.deleteTeacherByTeacherNo(teacherNo);
    }
    /**
     * 查找所有部门
     * */
    public List<Department>  findAllDepartment(){
        return  departmentDao.findAll();
    }
    /**
     * 查找所有角色
     * */
    public List<Role> findAllRoles(){
        return roleDao.findAll();
    }
    /**
     *根据teacherNo和teacherId不为这个的记录
     * */
    public Teacher findTeacherByTeacherNoWithTeacherId(String teacherNo,Integer teacherId){
        return teacherDao.findTeacherByTeacherNoWithTeacherId(teacherNo,teacherId);
    }


    public List<Course> findCoursesByTeacherNo(String teacherNo){
        return  courseDao.findCoursesByTeacherNo(teacherNo);
    }
    @Transactional
    public Integer deleteCoursesByTeacherNo(String teacherNo){
        return  courseDao.deleteCoursesByTeacherNo(teacherNo);
    }
    @Transactional
    public Integer deleteClazzesByCourseId(Integer courseId){
        return clazzDao.deleteClazzesByCourseId(courseId);
    }
}
