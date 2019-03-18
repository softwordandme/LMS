package com.lms.po;

public class Student {
    private Integer studentId;

    private Integer clazzId;

    private String studentName;

    private String studentNo;

    private String studentPassword;

    private String studentSex;

    private Integer departmentId;

    private Integer clazzNum;

    private String roleId;

    public Student(Integer studentId, Integer clazzId, String studentName, String studentNo, String studentPassword, String studentSex, Integer departmentId, Integer clazzNum, String roleId) {
        this.studentId = studentId;
        this.clazzId = clazzId;
        this.studentName = studentName;
        this.studentNo = studentNo;
        this.studentPassword = studentPassword;
        this.studentSex = studentSex;
        this.departmentId = departmentId;
        this.clazzNum = clazzNum;
        this.roleId = roleId;
    }

    public Student() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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
        this.roleId = roleId == null ? null : roleId.trim();
    }
}