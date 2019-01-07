package com.lms.dao;


import com.lms.po.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    Teacher findAllByTeacherNo(String teacherNo);
    Teacher findAllByTeacherNoAndDepartmentId(String teacherNo, Integer departmentId);

    List<Teacher> findTeachersByDepartmentId(Integer departmentId);


    List<Teacher> findTeachersByDepartmentIdAndRoleId(Integer departmentId, String roleId);
    @Transactional
    int deleteTeacherByTeacherNo(String teacherNo);

    /**
     *根据teacherNo查找记录
     * @param teacherNo 教师工号
     *@return List<Teacher>
     * */
    Teacher findTeacherByTeacherNo(String teacherNo);

    /**
     * 查询teacher
     * @param teacherNo 教师工号
     * @param  teacherId 标号
     * @return Teacher
     * */
    @Query(value = "select * from teacher where teacher_no = ?1 and teacher_id != ?2",nativeQuery = true)
    Teacher findTeacherByTeacherNoWithTeacherId(String teacherNo, Integer teacherId);
}
