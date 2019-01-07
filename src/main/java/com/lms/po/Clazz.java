package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Clazz") //指定表名为users  班级表
public class Clazz {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer id;         //id

    private Integer clazzNum;    //班级编号  如 1590008

    private Integer department; //系部ID，与系部表连接

    private String clazzName;//班级名称

    private Integer courseId;//课程id

    /**
     * 教师No
     */
    private String teacherNo;

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    /**
     * 不写数据
     */
    private String courseName;

    public Clazz() {
    }

    public Integer getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(Integer clazzNum) {
        this.clazzNum = clazzNum;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
