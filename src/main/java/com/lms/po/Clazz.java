package com.lms.po;

public class Clazz {
    private Integer id;

    private String clazzName;

    private Integer clazzNum;

    private Integer courseId;

    private String courseName;

    private Integer department;

    private String teacherNo;

    private String clazzname;

    private Integer clazznum;

    private Integer courseid;

    private String coursename;

    private String teacherno;

    public Clazz(Integer id, String clazzName, Integer clazzNum, Integer courseId, String courseName, Integer department, String teacherNo, String clazzname, Integer clazznum, Integer courseid, String coursename, String teacherno) {
        this.id = id;
        this.clazzName = clazzName;
        this.clazzNum = clazzNum;
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.teacherNo = teacherNo;
        this.clazzname = clazzname;
        this.clazznum = clazznum;
        this.courseid = courseid;
        this.coursename = coursename;
        this.teacherno = teacherno;
    }

    public Clazz() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName == null ? null : clazzName.trim();
    }

    public Integer getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(Integer clazzNum) {
        this.clazzNum = clazzNum;
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
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname == null ? null : clazzname.trim();
    }

    public Integer getClazznum() {
        return clazznum;
    }

    public void setClazznum(Integer clazznum) {
        this.clazznum = clazznum;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno == null ? null : teacherno.trim();
    }
}