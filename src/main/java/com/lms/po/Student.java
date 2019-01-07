package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Student")    //学生表
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer studentId;          //学生ID，唯一，自增

    private String studentNo;           //学生学号，栗子   159000803

    private String studentName;         //学生姓名

    private String studentPassword;     //学生密码

    private String studentSex;          //学生性别      男 ，  女

    private Integer clazzNum;            //班级Num 与班级表关联

    private String roleId;             //角色ID ，与角色表关联

    private Integer departmentId;      //部门ID ，与系部表关联



    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Integer getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(Integer clazzNum) {
        this.clazzNum = clazzNum;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getDepartmentId() { return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }


}
