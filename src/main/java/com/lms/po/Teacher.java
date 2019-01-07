package com.lms.po;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")  //教师表
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //自动增量
    private Integer teacherId;          //教师ID，唯一，自增

    private String teacherNo;           //教师工号

    private String teacherName;         //教师名字

    private String teacherPassword;     //教师密码

    private String teacherSex;          //教师性别，直接存男 女

    private String teacherStatus;       //教师状态  直接存 在职，离职

    private Integer departmentId;       //部门ID，与系部表连接

    private String roleId;             //角色ID  ，与角色表连接


    public Teacher() {
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
