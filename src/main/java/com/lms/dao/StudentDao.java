package com.lms.dao;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Demo class
 *
 * @author zz
 * @date 2019/1/1
 */
public interface StudentDao  {

    /**
     * 通过studentNo（学号/帐号）查询学生所有信息
     * @param  通过studentId 学生Id
     * @return Student
     */
    Student findStudentByStudentId(Integer studentId);


    /**
     * 增加学生
     * @param student 学生
     * @return int
     * */
    int addStudentDo(Student student);

    int editStudentDo(Student student);

    /**
     * 根据学号查询学生
     * @param studentNo 学号
     * @return List<Student>
     * */
    Student findStudentByStudentNo(String studentNo);

    List<Student> findAll();

    /**
     * 根据学生ID删除学生
     * @param  studentId 学生id
     * @return Integer
     */
    Integer deleteStudentByStudentId(Integer studentId);

    /**
     * 根据班级获取学生数
     * @param  clazzNum 班级编号
     * @return Integer
     */
    Integer countStudentsByClazzNum(Integer clazzNum);



    /**
     * 查询Student
     * @param studentNo 学号
     * @param studentId 标号
     * @return Teacher
     * */
    @Query(value = "select * from student where student_no = ?1 and student_id != ?2",nativeQuery = true)
    Student findStudentByStudentNoWithStudentId(String studentNo, Integer studentId);
}
