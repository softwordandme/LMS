package com.lms.dao;

import com.lms.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    /**
    通过studentNo（学号/帐号）查询学生所有信息
    */
    Student findAllByStudentNo(String studentNo);

    Student findStudentByStudentId(Integer studentId);

    @Override
    List<Student> findAll();

    @Transactional
    Integer deleteStudentByStudentId(Integer studentId);

    /**
     * 根据班级获取学生数
     * @param  clazzNum 班级编号
     * @return Integer
     */
    Integer countStudentsByClazzNum(Integer clazzNum);

    /**
     * 根据学号查询学生
     * @param studentNo 学号
     * @return List<Student>
     * */
    Student findStudentByStudentNo(String studentNo);

    /**
     * 查询Student
     * @param studentNo 学号
     * @param studentId 标号
     * @return Teacher
     * */
    @Query(value = "select * from student where student_no = ?1 and student_id != ?2",nativeQuery = true)
    Student findTeacherByStudentNoWithStudentId(String studentNo, Integer studentId);
}
