package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Course") //指定表名为Course 课程表
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer courseId;       //课程id，唯一，自增

    private String courseName;      //课程名称

    private String teacherNo;      //教师的工号,关联教师表

    /**
     * 课程学期，格式为String 2017-2018学年,第一学期
     */
    private Integer  termId;

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public Course() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }


}
