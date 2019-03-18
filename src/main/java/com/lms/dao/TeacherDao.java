package com.lms.dao;


import com.lms.po.Teacher;
import java.util.List;
/**
 * TeacherDao interface
 *
 * @author zz
 * @date 2019
 */
public interface TeacherDao{

    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);


    Teacher findAllByTeacherNo(String teacherNo);
    Teacher findAllByTeacherNoAndDepartmentId(String teacherNo, Integer departmentId);

    List<Teacher> findTeachersByDepartmentId(Integer departmentId);


    List<Teacher> findTeachersByDepartmentIdAndRoleId(Integer departmentId, String roleId);

    int deleteTeacherByTeacherNo(String teacherNo);

    /**
     * 查询teacher
     * @param teacherNo 教师工号
     * @param  teacherId 标号
     * @return Teacher
     * */
    Teacher findTeacherByTeacherNoWithTeacherId(String teacherNo, Integer teacherId);

    List<Teacher> findTeachers();
}
