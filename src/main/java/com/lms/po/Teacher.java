package com.lms.po;

public class Teacher {
    private Integer teacherId;

    private Integer departmentId;

    private String teacherName;

    private String teacherNo;

    private String teacherPassword;

    private String teacherSex;

    private String teacherStatus;

    private String roleId;

    public Teacher(Integer teacherId, Integer departmentId, String teacherName, String teacherNo, String teacherPassword, String teacherSex, String teacherStatus, String roleId) {
        this.teacherId = teacherId;
        this.departmentId = departmentId;
        this.teacherName = teacherName;
        this.teacherNo = teacherNo;
        this.teacherPassword = teacherPassword;
        this.teacherSex = teacherSex;
        this.teacherStatus = teacherStatus;
        this.roleId = roleId;
    }

    public Teacher() {
        super();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus == null ? null : teacherStatus.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}